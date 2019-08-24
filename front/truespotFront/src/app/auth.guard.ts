import { Injectable } from '@angular/core';
import {
  ActivatedRoute,
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree
} from '@angular/router';
import { Observable } from 'rxjs';
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
