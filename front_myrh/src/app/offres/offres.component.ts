import {Component, OnInit} from '@angular/core';
import {CurrentComponentService} from "../Services/current-component.service";
import {OffresService} from "../Services/offres.service";
import {Offres} from "../Classes/offres";
import {FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-offres',
  templateUrl: './offres.component.html',
  styleUrls: ['./offres.component.css']
})
export class OffresComponent implements OnInit{
  currentPage = 1;
  totalpages = 0;
  pageSize = 3;
  offres: Array<Offres> = [];
  // offresForm: FormGroup = this.fb.group({
  //   location: ['', Validators.required],
  //   amount: [0, [Validators.required, Validators.min(0)]],
  //   number_of_participants: [0, [Validators.required, Validators.min(0)]],
  //   date: [null, Validators.required],
  //   start_time: [null, [Validators.required]],
  //   end_time: [null, [Validators.required]],
  // });
  constructor(
    private currentComponentService: CurrentComponentService,
    private service: OffresService,
  ) {
  }

  ngOnInit() {
    this.currentComponentService.setCurrentComponent('jobes');
    this.getoffres();
    console.log(this.offres)
  }

  getoffres() {
    this.service.getoffres(this.currentPage - 1, this.pageSize)
      .subscribe({
        next: (resp ) => {
          // @ts-ignore
          console.log(resp.body.content)
          // @ts-ignore
          this.offres = resp.body.content as Array<Offres> ;
          // @ts-ignore
          this.totalpages = resp.body.totalPages;
        },
        error: (error) => {
          console.error('Error fetching offres:', error);
        },
      });
  }

  GoToPage(param: any) {
    this.currentPage = param;
    this.getoffres();
  }

}
