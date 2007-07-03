/* abc - The AspectBench Compiler
 * Copyright (C) 2007 Eric Bodden
 *
 * This compiler is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This compiler is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this compiler, in the file LESSER-GPL;
 * if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package abc.tm.weaving.weaver.tmanalysis;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import soot.Unit;
import abc.tm.weaving.weaver.tmanalysis.stages.TMShadowTagger.SymbolShadowTag;
import abc.tm.weaving.weaver.tmanalysis.util.ISymbolShadow;

/**
 * Some utility methods.
 *
 * @author Eric Bodden
 */
public class Util {

    /**
     * Returns a set of all active shadows in the given list of units.
     */
    public static Set<ISymbolShadow> getAllActiveShadows(Collection<? extends Unit> units) {
        Set<ISymbolShadow> allShadows = new HashSet<ISymbolShadow>();
    	for (Unit unit : units) {
            if(unit.hasTag(SymbolShadowTag.NAME)) {
            	SymbolShadowTag tag = (SymbolShadowTag) unit.getTag(SymbolShadowTag.NAME);
            	for (ISymbolShadow match : tag.getAllMatches()) {
    				if(match.isEnabled()) {
    					allShadows.add(match);
    				}
    			}
            }
    	}
        return allShadows;
    }

}
