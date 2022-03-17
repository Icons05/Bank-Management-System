import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Client } from '../model/client';
import { ClientService } from '../services/client.service';
import { FormsModule } from '@angular/forms';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-mod-client',
  templateUrl: './mod-client.component.html',
  styleUrls: ['./mod-client.component.css']
})
export class ModClientComponent implements OnInit 
{
  isConfirmed: boolean=false;
  msg: string="";
  client!: Client;
  sDate: string="";
  date!: Date;
  public myForm!: FormGroup;

  constructor(private clientService: ClientService, private route: ActivatedRoute) 
  { 
    this.client=new Client(0, '', '', 0, 0, new Date());
    this.createForm();
  }

  ngOnInit(): void 
  {
    console.log("In ngOnInit()")
    this.route.params.subscribe((parameters)=>
    {
        this.clientService.getClient(parseInt(parameters['clientId'])).subscribe((x)=>
        {
          this.client=x? x: null;
          let tmpDate=this.client.doj;
          this.date=this.jsonToDate(new Date(this.client.doj));
        });
    });
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

  mySubmit(): void
  {
    this.client.doj=this.date;
    this.msg=`Name ${this.client.name} AccountNumber ${this.client.accountNumber} Balance ${this.client.balance} OutstandingAmount ${this.client.outstandingAmount} Date of joining ${this.client.doj}`;
    this.clientService.modClient(this.client).subscribe((x)=>{console.log(x)});
  }

  myReset()
  {
    this.toggleConfirmed()
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

  jsonToDate(date: Date): Date 
  {
    date.setDate(date.getDate());
    return date;
  }
}

