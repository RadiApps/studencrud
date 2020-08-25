import {PersonType} from './PersonType';

export class Person{

    id: number;
    personType: PersonType;
    studentCode: number;
    fname: string;
    lname: string;
    gender: boolean;
    isUser: boolean;
    gradeYear: number;
    email: string;
    password: string;
    phoneNumber: string;
    birthDate: Date;
    createdDate: Date;
}