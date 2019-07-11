import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {map} from "rxjs/operators";



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {


  private loginURL : 'http://localhost:8080/login';

  constructor(private http: HttpClient) {
  }

  login(username: string, password: string) {
    return this.http.post<any>(this.loginURL, { username, password })
      .pipe(map(user => {
        // login successful if there's a jwt token in the response
        if (user && user.token) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
        }

        return user;
      }));
  }

  logOut() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }

}
