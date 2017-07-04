
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Joker/projects/rentalcars-rest-api/conf/routes
// @DATE:Tue Jul 04 12:21:27 BST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:18
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseCarsController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def getCarSummary: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarsController.getCarSummary",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "car/summary"})
        }
      """
    )
  
    // @LINE:12
    def getSortScore: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarsController.getSortScore",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "car/sort/score"})
        }
      """
    )
  
    // @LINE:15
    def getSortPrice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarsController.getSortPrice",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "car/sort/price"})
        }
      """
    )
  
    // @LINE:9
    def getSortCarRating: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CarsController.getSortCarRating",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "car/sort/rating"})
        }
      """
    )
  
  }


}
