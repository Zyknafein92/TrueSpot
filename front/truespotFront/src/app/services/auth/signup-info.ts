export class SignUpInfo {
    lastName: string;
    pseudo: string;
    email: string;
    role: string[];
    password: string;

    constructor(lastName: string, pseudo: string, email: string, password: string) {
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.role = ['user'];
    }
}
