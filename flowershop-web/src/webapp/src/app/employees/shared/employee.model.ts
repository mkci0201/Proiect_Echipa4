export class Employee {
  id: number;
  username: string;
  firstName: string;
  lastName: string;
  role: EmployeeRole;
  dateOfBirth: string;
  phoneNumber: string;
  password: string;
  shopOrder: number[];
}

export enum EmployeeRole{
  Administrator,
  User,
}

export const EMPLOYEE_ROLE_TYPES = ['Administrator', 'User',];
