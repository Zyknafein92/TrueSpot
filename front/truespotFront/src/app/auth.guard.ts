import {Injectable} from '@angular/core';
import {ActivatedRoute, CanActivate, Router} from '@angular/router';
import {AuthService} from "./services/auth/auth.service";
import {TokenStorageService} from "./services/auth/token-storage.service";


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authServices: AuthService, private router: Router, private route: ActivatedRoute, private token:TokenStorageService) {
  }

  canActivate(): boolean {
    if (!this.token.getToken()) {
      this.router.navigate(['sign-in']);
      return false;
    }
    return true;
  }
}
