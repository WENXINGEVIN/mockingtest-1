var Lane = {
        name: "Lane the Lambda",
        description: function () {
                        return "A person named " + this.name;
                }
};

var Fred = {
name: "Fred the Functor",
descr: Lane.description
};

console.log(Fred.descr());
