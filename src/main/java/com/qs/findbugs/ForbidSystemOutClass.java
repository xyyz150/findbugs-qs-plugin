package com.qs.findbugs;
  
import org.apache.bcel.classfile.Code;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.OpcodeStackDetector;
  
public class ForbidSystemOutClass extends OpcodeStackDetector {  
	
    private BugReporter bugReporter;  
  
    public ForbidSystemOutClass(BugReporter bugReporter) {  
        this.bugReporter = bugReporter;  
    }  
  
    @Override  
    public void visit(Code obj) {  
        super.visit(obj);  
    }  
  
    @Override  
    public void sawOpcode(int seen) {  

    	if (seen == GETSTATIC) {

            if ("java/lang/System".equals(getClassConstantOperand())
                    && ("out".equals(getNameConstantOperand()) || "error".equals(getNameConstantOperand()))) {
            	
            	bugReporter.reportBug( new BugInstance("SYSTEM_OUT_ERROR", HIGH_PRIORITY) 
            							.addClassAndMethod(this).addSourceLine(this)); 
            }
        }
        if(seen==INVOKEVIRTUAL){
            if ("java/lang/Exception".equals(getClassConstantOperand())
                    && ("printStackTrace".equals(getNameConstantOperand()))) {

                bugReporter.reportBug( new BugInstance("PRINTSTACKTRACE_ERROR", HIGH_PRIORITY)
                        .addClassAndMethod(this).addSourceLine(this));
            }
        }
  
  
    }  
}  