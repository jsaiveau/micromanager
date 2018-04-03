import {
    NgModule,
    Component,
    Pipe,
    OnInit
} from '@angular/core';
import {
    ReactiveFormsModule,
    FormsModule,
    FormGroup,
    FormControl,
    Validators,
    FormBuilder
} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {MicroserviceService} from "../../../../_services/microservice.service";
import {MicroserviceGroup} from "../../../../_models/MicroserviceGroup";
import {Microservice} from "../../../../_models/Microservice";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
    selector: 'app-service-form',
    templateUrl: './service-form.component.html',
    styleUrls: ['./service-form.component.css']
})

export class ServiceFormComponent implements OnInit {
    groups: MicroserviceGroup[] = new Array();
    serviceForm: FormGroup;
    microserviceRequest: Microservice;
    sourcePage : string;
    groupId : string;

    constructor(private microserviceService : MicroserviceService, private activatedRoute: ActivatedRoute, private router: Router) { }

    ngOnInit() {
        this.microserviceService.loadGroups().subscribe(
            data => { this.groups = data},
            err => console.error(err),
            () => console.log('Loaded all microservice groups')
        );

        this.serviceForm = new FormGroup({
            serviceName: new FormControl('', [
                Validators.required
            ]),
            description: new FormControl('', [
                Validators.required
            ]),
            group: new FormControl()
        });

        this.activatedRoute.queryParamMap
            .subscribe(params => {
                if(params.get('sourcePage')) {
                    this.sourcePage = params.get('sourcePage');
                }
                if(params.get('group')) {
                    this.groupId = params.get('group');
                    this.serviceForm.patchValue({
                        group:  this.groupId
                    });
                }

            });
    }

    onSubmit() {
        if (this.serviceForm.valid) {
            this.microserviceRequest = new Microservice();
            this.microserviceRequest.name = this.serviceForm.controls['serviceName'].value;
            this.microserviceRequest.description = this.serviceForm.controls['description'].value;
            this.microserviceRequest.groupId = this.serviceForm.controls['group'].value;

            this.microserviceService.addMicroservice(this.microserviceRequest).subscribe(res => {
                if(res) {
                    this.serviceForm.reset();
                    if (this.sourcePage == 'dashboard') {
                        this.router.navigate(['/']);
                    }
                }
            }, err => {
                console.log("Error occured: " + err);
            });
        }
    }
}