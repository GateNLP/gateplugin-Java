import gate.Utils;

@Override
public void execute() {
  System.out.println("Hello World");

  System.out.println("The document is "+doc);
  System.out.println("The controller is "+controller);
  System.out.println("The corpus is "+corpus);
  System.out.println("The globalsForAll is: "+globalsForAll);
  System.out.println("The globalsForScript is: "+globalsForPr);
  System.out.println("DOES IT WORK?");
}

@Override
public void initAll() {
  System.out.println("Doing the global initialization");
  globalsForAll.put("Something",1);
  globalsForAll.put("SomethingElse","This"); 
  System.out.println("GlobalsForAll is now: "+globalsForAll);
}

public void initPr() {
  System.out.println("Doing the PR initialization");
}
