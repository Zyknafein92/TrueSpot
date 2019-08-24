import { Injectable } from '@angular/core';
import {NavigationEnd, Router} from '@angular/router';
import {filter} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PushRouteService {


  private history = [];
  private static router_static: Router;

  constructor(private router: Router) {
  }

  pushRoute(route: string) {
    this.router.navigate([route]);
  }

  navigateByUrl(url: string) {
    this.router.navigateByUrl(url);
  }
  public static navigateByUrl2(url: string) {
    this.router_static.navigateByUrl(url);
  }

  public loadRouting(): void {
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe(({urlAfterRedirects}: NavigationEnd) => {
        this.history = [...this.history, urlAfterRedirects];
      });
  }

  public getHistory(): string[] {
    return this.history;
  }

  public getPreviousUrl(): string {
    return this.history[this.history.length - 2] || '/index';
  }
}
