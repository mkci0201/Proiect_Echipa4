export class Product {
  id: number;
  name: string;
  description: string;
  color: ProductColor;
  price: number;
  stock: number;
}


export enum ProductColor{
  White,
  Yellow,
  Blue,
  Black,
  Red,
  Purple,
  Green,
  Orange,
  Pink
}

export const PRODUCT_COLOR_TYPES = ['White', 'Yellow', 'Blue', 'Black', 'Red', 'Purple', 'Green', 'Orange', 'Pink'];
