import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin.component';


const routes: Routes = [
    {
        path: '', component: AdminComponent, children: [
            { path: '', redirectTo:'ofertas', pathMatch: 'full' },
            { path: 'usuarios', loadChildren: () => import('../usuario/usuario.module').then(m => m.UsuarioModule) },
            { path: 'itens', loadChildren: () => import('../item/item.module').then(m => m.ItemModule) },
            { path: 'ofertas', loadChildren: () => import('../oferta/oferta.module').then(m => m.OfertaModule) },
            { path: 'minhas-pecas', loadChildren: () => import('../minhas-pecas/minhas-pecas.module').then(m => m.MinhasPecasModule) },
            { path: 'minhas-ofertas', loadChildren: () => import('../minhas-ofertas/minhas-ofertas.module').then(m => m.MinhasOfertasModule) }
        ]
    }

];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AdminRoutingModule { }
