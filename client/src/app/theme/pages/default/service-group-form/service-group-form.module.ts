import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import {ServiceGroupFormComponent} from "./service-group-form.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

import {HttpClientModule} from "@angular/common/http";
import {DefaultComponent} from "../default.component";
import {LayoutModule} from "../../../layouts/layout.module";
import {MicroserviceService} from "../../../../_services/microservice.service";

const routes: Routes = [
    {
        "path": "",
        "component": DefaultComponent,
        "children": [
            {
                "path": "",
                "component": ServiceGroupFormComponent
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
        ServiceGroupFormComponent
    ], providers: [MicroserviceService]
})
export class ServiceGroupFormModule {



}