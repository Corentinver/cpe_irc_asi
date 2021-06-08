export class User {
    name: string;
    surname: string;
    password: string;

    constructor(name: string, surname: string, password: string) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

}


export class UserConnected {
    id: number;
    name: string;
    surname: string;
    money: number;

    constructor(id: number, surname: string, name: string, money: number) {
        this.money = money;
        this.surname = surname;
        this.id = id;
        this.name = name;
    }

}