// min/max number in an array

var numbers = [5, 6, 2, 3, 7];

// using Math.min/Math.max apply
var max = Math.max.apply(null, numbers); 
// This about equal to Math.max(numbers[0], ...)
// or Math.max(5, 6, ...)

var min = Math.min.apply(null, numbers);

// vs. simple loop based algorithm

max = -Infinity, min = +Infinity;

for (var i = 0; i < numbers.length; i++) {
  if (numbers[i] > max) {
    max = numbers[i];
  }
  if (numbers[i] < min) {
    min = numbers[i];
  }
}