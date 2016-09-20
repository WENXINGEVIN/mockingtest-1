/*
 *   This example is to demo a chain of constructors
 *   Run this as Node Application in eclipse;
 *   
 *   Return value

     The result of calling the function with the specified this value and arguments.

	 Description

	 A different this object can be assigned when calling an existing function. this refers to the current object, the calling object. With call, you can write a method once and then inherit it in another object,
	 without having to rewrite the method for the new object.
 * 
 * */

function Product(name, price) {
  this.name = name;
  this.price = price;

  if (price < 0) {
    throw RangeError('Cannot create product ' +
                      this.name + ' with a negative price');
  }
}

function Food(name, price) {
  Product.call(this, name, price);
  this.category = 'food';
}

function Toy(name, price) {
  Product.call(this,name, price);
  this.category = 'toy';
}

var cheese = new Food('feta', 5);
var fun = new Toy('robot', 40);

console.log(cheese);
console.log(fun);