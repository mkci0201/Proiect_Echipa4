import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";
import {Employee} from "../../employees/shared/employee.model";

export class ShopOrder {
  id: number;
  date: string;
  category: Category;
  orderedProducts: Array<OrderedProduct>;
  employee: Employee;
}

export enum Category{
  Bouquets,
  Arrangements,
  Plants,
  Flower,

}
export const CATEGORY_TYPES = ['Bouquets', 'Arrangements', 'Plants', 'Flower'];
