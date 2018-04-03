import { NgModule } from '@angular/core';
import { ThemeComponent } from './theme.component';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from "../auth/_guards/auth.guard";

const routes: Routes = [
    {
        "path": "",
        "component": ThemeComponent,
        "canActivate": [AuthGuard],
        "children": [
            {
                "path": "index",
                "loadChildren": ".\/pages\/aside-left-display-disabled\/index\/index.module#IndexModule"
            },
            {
                "path": "inner",
                "loadChildren": ".\/pages\/default\/inner\/inner.module#InnerModule"
            },
            {
                "path": "profile",
                "loadChildren": ".\/pages\/default\/profile\/profile.module#ProfileModule"
            },
            {
                "path": "service",
                "loadChildren": ".\/pages\/default\/service-form\/service-form.module#ServiceFormModule"
            },
            {
                "path": "service/:id",
                "loadChildren": ".\/pages\/default\/service-form\/service-form.module#ServiceFormModule"
            },
            {
                "path": "service-group",
                "loadChildren": ".\/pages\/default\/service-group-form\/service-group-form.module#ServiceGroupFormModule"
            },
            {
                "path": "service-group/:id",
                "loadChildren": ".\/pages\/default\/service-group-form\/service-group-form.module#ServiceGroupFormModule"
            },
            {
                "path": "404",
                "loadChildren": ".\/pages\/default\/not-found\/not-found.module#NotFoundModule"
            },
            {
                "path": "",
                "redirectTo": "index",
                "pathMatch": "full"
            }
        ]
    },
    {
        "path": "**",
        "redirectTo": "404",
        "pathMatch": "full"
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class ThemeRoutingModule { }