import { Injectable }     from '@angular/core';
import { CanActivate }    from '@angular/router';
import { Router } from '@angular/router';
import { AuthentificationService } from './services/authentification.service';

@Injectable()
export class AuthGuard implements CanActivate {
    
    constructor(private router: Router, private authentificationService: AuthentificationService) { }

    canActivate() {
        if (!this.authentificationService.currentUser) {
            this.router.navigate(['/login']);
            return;
        }
        return true;
    }

}