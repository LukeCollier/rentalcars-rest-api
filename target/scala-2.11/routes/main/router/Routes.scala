
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Joker/projects/rentalcars-rest-api/conf/routes
// @DATE:Tue Jul 04 12:21:27 BST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  CarsController_1: controllers.CarsController,
  // @LINE:18
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    CarsController_1: controllers.CarsController,
    // @LINE:18
    Assets_0: controllers.Assets
  ) = this(errorHandler, CarsController_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, CarsController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/summary""", """controllers.CarsController.getCarSummary"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/sort/rating""", """controllers.CarsController.getSortCarRating"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/sort/score""", """controllers.CarsController.getSortScore"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """car/sort/price""", """controllers.CarsController.getSortPrice"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_CarsController_getCarSummary0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/summary")))
  )
  private[this] lazy val controllers_CarsController_getCarSummary0_invoker = createInvoker(
    CarsController_1.getCarSummary,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarsController",
      "getCarSummary",
      Nil,
      "GET",
      """ A summary of the cars""",
      this.prefix + """car/summary"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CarsController_getSortCarRating1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/sort/rating")))
  )
  private[this] lazy val controllers_CarsController_getSortCarRating1_invoker = createInvoker(
    CarsController_1.getSortCarRating,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarsController",
      "getSortCarRating",
      Nil,
      "GET",
      """ The rating sorted by descending""",
      this.prefix + """car/sort/rating"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_CarsController_getSortScore2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/sort/score")))
  )
  private[this] lazy val controllers_CarsController_getSortScore2_invoker = createInvoker(
    CarsController_1.getSortScore,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarsController",
      "getSortScore",
      Nil,
      "GET",
      """ Sorted by score ascending""",
      this.prefix + """car/sort/score"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_CarsController_getSortPrice3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("car/sort/price")))
  )
  private[this] lazy val controllers_CarsController_getSortPrice3_invoker = createInvoker(
    CarsController_1.getSortPrice,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CarsController",
      "getSortPrice",
      Nil,
      "GET",
      """ Price ascending""",
      this.prefix + """car/sort/price"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_CarsController_getCarSummary0_route(params) =>
      call { 
        controllers_CarsController_getCarSummary0_invoker.call(CarsController_1.getCarSummary)
      }
  
    // @LINE:9
    case controllers_CarsController_getSortCarRating1_route(params) =>
      call { 
        controllers_CarsController_getSortCarRating1_invoker.call(CarsController_1.getSortCarRating)
      }
  
    // @LINE:12
    case controllers_CarsController_getSortScore2_route(params) =>
      call { 
        controllers_CarsController_getSortScore2_invoker.call(CarsController_1.getSortScore)
      }
  
    // @LINE:15
    case controllers_CarsController_getSortPrice3_route(params) =>
      call { 
        controllers_CarsController_getSortPrice3_invoker.call(CarsController_1.getSortPrice)
      }
  
    // @LINE:18
    case controllers_Assets_versioned4_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
