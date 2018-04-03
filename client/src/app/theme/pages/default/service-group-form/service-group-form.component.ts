import {
    Component,
    OnInit
} from '@angular/core';
import {
    FormGroup,
    FormControl,
    Validators
} from '@angular/forms';
import {MicroserviceService} from "../../../../_services/microservice.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MicroserviceGroup} from "../../../../_models/MicroserviceGroup";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-service-group-form',
    templateUrl: './service-group-form.component.html',
    styleUrls: ['./service-group-form.component.css']
})

export class ServiceGroupFormComponent implements OnInit {

    serviceGroupForm: FormGroup;
    sourcePage : string;

    constructor(private microserviceService : MicroserviceService, private activateRoute: ActivatedRoute, private router: Router) {}

    ngOnInit() {
        this.activateRoute.queryParams
            .filter(params => params.sourcePage)
            .subscribe(params => {
                console.log(params); // {order: "popular"}

                this.sourcePage = params.sourcePage;
                console.log(this.sourcePage); // popular
            });

        this.serviceGroupForm = new FormGroup({
            name: new FormControl('', [
                Validators.required
            ]),
            description: new FormControl('', [
                Validators.required
            ])
        });
    }

    onSubmit() {
        if (this.serviceGroupForm.valid) {
            console.log("Form Submitted!");

            this.microserviceService.createGroup(this.serviceGroupForm.value).subscribe(res => {
                if(res) {
                    this.serviceGroupForm.reset();
                    if (this.sourcePage == 'add-service') {
                        this.router.navigate(['/service'], { queryParams: { group: res.id } });
                    }
                }
            }, err => {
                console.log("Error occured: " + err);
            });
        }
    }
}