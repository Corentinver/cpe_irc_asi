import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule}   from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import {MatTabsModule} from '@angular/material/tabs';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { BuyComponent } from './buy/buy.component';
import { MenuComponent } from './menu/menu.component';
import { SellComponent } from './sell/sell.component';
import { AuthGuard } from './auth-guard';
import { ListCardsComponent } from './menu/list-cards/list-cards.component';
import { RxStompService } from '@stomp/ng2-stompjs';
import { CardShopWebSocketService } from './services/card-shop-web-socket.service';
import { CardCollectionWebSocketService } from './services/card-collection-web-socket.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BuyComponent,
    MenuComponent,
    SellComponent,
    ListCardsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatTabsModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    AuthGuard,
    RxStompService,
    CardShopWebSocketService,
    CardCollectionWebSocketService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
