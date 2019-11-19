import {Role} from "./role.model";

export class UserAccount {

  userId :number;
  login: string;
  password :string;
  name: string;
  surname: string;
  email: string;
  address: string;
  rolesByRoleId: Role;


  constructor() {
    this.rolesByRoleId = new Role();
  }
}
