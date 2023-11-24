package cms.cm7.boutonInc;

//Controller
class Controller {
 private static CounterModel model;
 private static CounterView view;

 public static void main(String[] args) {
     model = new CounterModel();
     view = new CounterView();
 }

 public static void handleButtonClick() {
     // Update the model
     model.incrementCounter();

     // Update the view
     view.updateCounter(model.getCounter());
 }
 
}