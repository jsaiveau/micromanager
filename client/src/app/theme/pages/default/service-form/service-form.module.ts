import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LayoutModule } from '../../../layouts/layout.module';
import { DefaultComponent } from '../default.component';
import {ServiceFormComponent} from "./service-form.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MicroserviceService} from "../../../../_services/microservice.service";
import {HttpClientModule} from "@angular/common/http";

const routes: Routes = [
    {
        "path": "",
        "component": DefaultComponent,
        "children": [
            {
                "path": "",
                "component": ServiceFormComponent
            }
        ]
    }
];
@NgModule({
    imports: [
        CommonModule, RouterModule.forChild(routes), LayoutModule, HttpClientModule,
        FormsModule, ReactiveFormsModule
    ], exports: [
        RouterModule
    ], declarations: [
        ServiceFormComponent
    ], providers: [MicroserviceService]
})
export class ServiceFormModule {



}