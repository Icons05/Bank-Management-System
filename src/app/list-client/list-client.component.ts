import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientService } from '../services/client.service';
import { Client } from '../model/client';

@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.css']
})
export class ListClientComponent implements OnInit {
  clients : Client[]=[];
  constructor(private clientService: ClientService, private route: ActivatedRoute) 
  { 

  }

  ngOnInit(): void 
  {
    this.clientService.getClients().subscribe((x)=>{ this.clients=x });
    //this.clientService.getClient(100).subscribe((x)=>{this.clients.push(x)});
  }

  delClient(event: any, index: any) 
  {  
    let id=this.clients[index].clientId;
    
    this.clientService.delClient(id)  
      .subscribe((data: any) => 
      {  
        console.log(data);  
        this.ngOnInit();
      });

    //this.clientService.getClients().subscribe(x =>{ this.clients=x },   
    //  (error: any) => { return console.log(error); });
  }
}
