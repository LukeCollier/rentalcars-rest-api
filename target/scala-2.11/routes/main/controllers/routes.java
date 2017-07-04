
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Joker/projects/rentalcars-rest-api/conf/routes
// @DATE:Tue Jul 04 12:21:27 BST 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCarsController CarsController = new controllers.ReverseCarsController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCarsController CarsController = new controllers.javascript.ReverseCarsController(RoutesPrefix.byNamePrefix());
  }

}
