// This is the class from which all the objects generated
// for a script inherit
package com.jpetrak.gate.java;

import gate.Document;
import gate.Controller;
import gate.AnnotationSet;
import gate.Corpus;
import gate.FeatureMap;
import gate.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class JavaScripting  {
  public static ConcurrentMap<String,Object> globalsForAll = new ConcurrentHashMap<String,Object>();
  public ConcurrentMap<String,Object> globalsForPr = null;  // will be set by JavaSriptingPR
  public Document doc = null;
  public Controller controller = null;
  public Corpus corpus = null;
  public AnnotationSet inputAS = null;
  public String inputASName = null;
  public String outputASName = null;
  public AnnotationSet outputAS = null;
  public FeatureMap parms = null;
  public Resource resource1 = null;
  public Resource resource2 = null;
  public Resource resource3 = null;
  public void execute() { 
  }
  public void controllerStarted()  { }
  public void controllerFinished()  { }
  public void controllerAborted( Throwable throwable)  { }
  public void initPr() { }
  public void initAll() { }
  
  
  
  
  
  void callExecute() {
    callInitAll();
    callInitPr();
    execute();
  }
  // This is an object that allows to serialize code so that only one instance
  // of several custom-duplicated ones will be run.
  // This will get set, by the PR which creates the first instance of this class
  // for a script. When that PR gets c
  public Object lockForPr = null;
  public boolean initializedForPr = false;
  private void callInitPr() { 
    if(initializedForPr) return;
    synchronized(lockForPr) {
      if(!initializedForPr) {
        initPr();
        initializedForPr = true;
      }
    }
  }
  // This is an object that loows to serialize code so that only one instance
  // of all JavaScripting instances in the VM will run. 
  public static Object lockForAll = new Object();
  public static boolean initializedForAll = false;
  private void callInitAll() { 
    if(initializedForAll) return;
    synchronized(lockForAll) {
      if(!initializedForAll) {
        initAll();
        initializedForAll = true;
      }
    }
  }
  
  public static void resetInitAll() {
    synchronized(lockForAll) {
      initializedForAll = false;
      globalsForAll = new ConcurrentHashMap<String,Object>();
    }
  }
  
}
