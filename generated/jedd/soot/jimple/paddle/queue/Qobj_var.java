package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public abstract class Qobj_var implements DepItem {
    public Qobj_var(String name) {
        super();
        this.name = name;
    }
    
    protected String name;
    
    public final String toString() { return name; }
    
    public abstract void add(AllocNode _obj, VarNode _var);
    
    public abstract void add(final jedd.internal.RelationContainer in);
    
    public abstract Robj_var reader(String rname);
    
    public Robj_var revreader(String rname) { return reader(rname); }
    
    public void add(Robj_var.Tuple in) { add(in.obj(), in.var()); }
    
    private boolean valid = true;
    
    public boolean update() {
        boolean ret = !valid;
        valid = true;
        return true;
    }
    
    public void invalidate() {
        if (!valid) return;
        valid = false;
    }
}
