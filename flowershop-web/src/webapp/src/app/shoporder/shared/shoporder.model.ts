import {OrderedProduct} from "../../orderedproducts/shared/orderedproduct.model";

export class ShopOrder {
  id: number;
  date: string;
  category: Category;
  orderedProducts: Array<OrderedProduct>;
}

export enum Category{
  Bouquets,
  Arrangements,
  Plants,
  Flower,
  Decoration,

}
export const CATEGORY_TYPES = ['Bouquets', 'Arrangements', 'Plants', 'Flower', 'Decoration'];
