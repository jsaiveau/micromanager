import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { IndexComponent } from './index.component';
import { LayoutModule } from '../../../layouts/layout.module';
import { AsideLeftDisplayDisabledComponent } from '../aside-left-display-disabled.component';
import {TotalServicesComponent} from "../../default/total-services/total-services.component";
import {MicroserviceService} from "../../../../_services/microservice.service";

const routes: Routes = [
    {
        "path": "",
        "component": AsideLeftDisplayDisabledComponent,
        "children": [
            {
                "path": "",
                "component": IndexComponent
            }
        ]
    }
];
@NgModule({
    imports: [
        CommonModule, RouterModule.forChild(routes), LayoutModule, HttpClientModule
    ], exports: [
        RouterModule
    ], declarations: [
        IndexComponent, TotalServicesComponent
    ], providers: [MicroserviceService]
})
export class IndexModule {



}