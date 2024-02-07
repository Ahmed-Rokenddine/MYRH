import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {OffresService} from "../Services/offres.service";
import {switchMap} from "rxjs";

@Component({
  selector: 'app-offre',
  templateUrl: './offre.component.html',
  styleUrls: ['./offre.component.css']
})
export class OffreComponent implements OnInit {
  offres: any;
  offreId!: number;
  isPostulationAchieved: boolean = false;


  constructor(

    private route: ActivatedRoute,
    private service: OffresService,

  ) {

  }

  ngOnInit() {
    this.offreId = parseInt(<string>this.route.snapshot.paramMap.get('id'));
    this.getoffreById();
    console.log(this.offres)
  }
  postuler() {
    console.log("postuler")
    this.isPostulationAchieved = true;
  }


  getoffreById() {
    this.service
      .getoffreById(this.offreId)
      .pipe(
        switchMap((offreData) => {
          this.offres = offreData;
          return this.offres;
        })
      )
      .subscribe((offresData) => {
        this.offres = offresData;
      });
  }
}
