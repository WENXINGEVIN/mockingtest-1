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

var descr = Lane.description;

Lane.description.call(
  { name: "zed the zetabyte" }
); 

