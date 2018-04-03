import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {MicroserviceInfo} from "../_models/MicroserviceInfo";
import {MicroserviceGroup} from "../_models/MicroserviceGroup";
import {Microservice} from "../_models/Microservice";

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class MicroserviceService  {
    constructor(private http:HttpClient) {}

    loadTotalServiceInfo() : Observable<MicroserviceInfo[]> {
        return this.http.get<MicroserviceInfo[]>('http://localhost:8080/api/microservices');
    }

    loadGroups() : Observable<MicroserviceGroup[]> {
        return this.http.get<MicroserviceGroup[]>('http://localhost:8080/api/microservice-groups');
    }

    createGroup( createJson ) :  Observable<MicroserviceGroup> {
        return this.http.post<MicroserviceGroup>('http://localhost:8080/api/microservice-groups',createJson);
    }

    addMicroservice( addJson )  :  Observable<Microservice> {
        return this.http.post<Microservice>('http://localhost:8080/api/microservices',addJson);
    }
}