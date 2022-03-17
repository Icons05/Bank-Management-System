import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Client } from '../model/client';
import { ClientService } from '../services/client.service';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {

  isConfirmed: boolean=false;
  msg: string="";
  client!: Client;
  mName: string="";
  
  public myForm!: FormGroup;
  constructor(private clientService : ClientService) { 
    this.client=new Client(0, "", "", 0, 0, new Date(0));
    this.createForm();
  }

  ngOnInit(): void {
  }

  createForm()
  {
    this.myForm=new FormGroup({
      name: new FormControl(null, [Validators.required]),
      accountNumber: new FormControl(null, [Validators.required]),
      balance: new FormControl(null, [Validators.required, Validators.min(1000), Validators.max(100000000)]),
      outstandingAmount: new FormControl(null, [Validators.required, Validators.min(500), Validators.max(2000000)]),
      doj: new FormControl(new Date(0), [Validators.required])
    });
  }

  mySubmit()
  {
    this.msg=`Name ${this.client.name} AccountNumber ${this.client.accountNumber} Balance ${this.client.balance} OutstandingAmount ${this.client.outstandingAmount} Date of joining ${this.client.doj}`;
    this.clientService.addClient(this.client).subscribe((x)=>{console.log(x)});
  }
  toggleConfirmed()
  {
    if(this.myForm.valid)
    {
      this.isConfirmed=!this.isConfirmed;
    }
  }
  get name()
  {
    return this.myForm.get('name');
  }
  get accountNumber()
  {
    return this.myForm.get('accountNumber');
  }
  get balance()
  {
    return this.myForm.get('balance');
  }
  get outstandingAmount()
  {
    return this.myForm.get('outstandingAmount');
  }
  get doj()
  {
    return this.myForm.get('doj');
  }
}

