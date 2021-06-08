import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../model/login.model';
import { User, UserConnected } from '../model/user.model';
import { AuthentificationService } from '../services/authentification.service';


export class EqualsValidator {

  /**
   * compares 2 values
   * */
  static equals(valueControlNameA: string, valueControlNameB: string) {
    return (group: FormGroup): {[key: string]: any} => {
      // get values
      let valueA = group.get(valueControlNameA).value;
      let valueB = group.get(valueControlNameB).value;

      return valueA === valueB ? null : {equals: true}; 
    }
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private authentificationService: AuthentificationService, private route: Router) { }

  registerForm: FormGroup;
  loginForm: FormGroup;

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      surname: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      repassword: new FormControl('', [Validators.required])
    });
    this.registerForm.setValidators(EqualsValidator.equals('password', 'repassword'))

    this.loginForm = new FormGroup({
      surname: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  
  }


  login() {
    console.log(this.registerForm.get('surname').value);
    this.authentificationService.login(new Login(
      this.loginForm.get('surname').value,
      this.loginForm.get('password').value
    )).subscribe((data) => {
      console.log('here');
      this.authentificationService.currentUser = data;
      this.route.navigate(['menu']);
    });
  }

  register() {
    this.authentificationService.createUser(
      new User(this.registerForm.get('name').value,
      this.registerForm.get('surname').value,
      this.registerForm.get('password').value
    )).subscribe((data) => {
      this.authentificationService.currentUser = data;
      this.route.navigate(['menu']);
    });
  }
}
