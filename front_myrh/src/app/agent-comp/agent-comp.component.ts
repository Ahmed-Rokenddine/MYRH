import {Component, OnInit} from '@angular/core';
import {Offres} from "../Classes/offres";
import {CurrentComponentService} from "../Services/current-component.service";
import {OffresService} from "../Services/offres.service";

@Component({
  selector: 'app-agent-comp',
  templateUrl: './agent-comp.component.html',
  styleUrls: ['./agent-comp.component.css']
})
export class AgentCompComponent implements OnInit{
  currentPage = 1;
  totalpages = 0;
  pageSize = 3;
  offres: Array<Offres> = [];
  constructor(
    private currentComponentService: CurrentComponentService,
    private service: OffresService,
  ) {
  }

  ngOnInit() {
    this.currentComponentService.setCurrentComponent('agent');
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
  acceptOffer(offer: any) {
    // Implement logic to change the status to "Accepted" and update your data
    // For example, you can call a service to update the offer status in the backend
  }

  refuseOffer(offer: any) {
    // Implement logic to change the status to "Refused" and update your data
    // For example, you can call a service to update the offer status in the backend
  }

  GoToPage(param: any) {
    this.currentPage = param;
    this.getoffres();
  }

}
