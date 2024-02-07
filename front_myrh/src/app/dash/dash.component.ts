import {Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {OffresService} from "../Services/offres.service";
@Component({
  selector: 'app-dash',
  templateUrl: './dash.component.html',
  styleUrls: ['./dash.component.css']
})
export class DashComponent implements OnInit{

  showForm = false;


  offreForm: FormGroup = this.fb.group({
    profil: ['', Validators.required],
    salaire: [0, [Validators.required, Validators.min(0)]],
    study: ['', Validators.required],
    ville: ['', Validators.required],
    society_id: [1 ],
    status: ['PENDING'],
  });

  constructor(

    private service: OffresService,
    private fb: FormBuilder
  ) {}

  addOffre() {
    this.showForm = true;
  }
  ngOnInit() {


    // Initialize the competitionForm with custom time validator
    this.offreForm = this.fb.group({
      profil: ['', Validators.required],
      salaire: [0, [Validators.required, Validators.min(0)]],
      study: ['', [Validators.required, Validators.min(0)]],
      ville: ['', Validators.required],
      society:{
        id:1
      },
      status: ['PENDING'],

      // Add more form controls as needed
    });
  }

  onSubmit() {
    console.log(this.offreForm.value);
    if (this.offreForm.valid) {
      // Perform actions with the form data, e.g., add a new competition
      const newOffre = this.offreForm.value;

      // Call your service method to add the competition
      this.service.addoffre(newOffre).subscribe(
        (error) => {
          console.log('Competition added successfully:', error);
          console.log(newOffre);

          // Add the newly created competition to the existing array

        },
        (response) => {
          console.error('Error adding competition:', response);


        }
      );

      // Reset the form and hide it
      this.offreForm.reset();
      this.showForm = false;
    }
  }

}
