package english.dependency.label;

import java.util.HashMap;
import java.util.Map;

public final class EDependencyLabel {
	public static final String[] PENN_DEP_STRINGS = new String[] {
		"-NONE-",
		"{S[pt]\\NP}/S[bem]",
		"{{S[ng]\\NP}/S[dcl]}/{S[adj]\\NP}",
		"{PP/NP}/N[num]",
		"{S[dcl]\\NP[thr]}/{S[pt]\\NP}",
		"{{{S[dcl]\\NP}/{S[ng]\\NP}}/PP}/NP",
		"S/{S[pss]\\NP}",
		"{{NP\\NP}/S[qem]}\\NP",
		"S[wq]/S[b]",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}\\{S[adj]\\NP}",
		"{S[ng]\\NP}/{S[b]\\NP}",
		"{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}",
		"{NP/NP}/N[num]",
		"{NP\\NP}/S[intj]",
		"{{S\\NP}\\{S\\NP}}/N[num]",
		"{{S[adj]\\NP}/{S[adj]\\NP}}\\NP",
		"{{S[b]\\NP}/{S[to]\\NP}}/NP",
		"{S[dcl]\\NP}/S[qem]",
		"{{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}\\{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}}/{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}",
		"{S[b]\\NP}/S[q]",
		"{S\\S}/S[wq]",
		"{NP/{{S[to]\\NP}/NP}}/N",
		"{NP\\NP}/S[em]",
		"{{NP\\NP}\\{NP\\NP}}/{S[ng]\\NP}",
		"{S[q]/{S[adj]\\NP}}/NP",
		"{{N/N}/{N/N}}/N",
		"PP/S",
		"{{{S[b]\\NP}/S[em]}/PP}/NP[expl]",
		"{S[dcl]\\NP[expl]}/{S[ng]\\NP}",
		"S[qem]/{S[b]\\NP}",
		",",
		"S[adj]",
		".",
		"{PP\\PP}\\NP",
		"{{S[qem]/{S[to]\\NP}}\\{{NP\\NP}/NP}}/N",
		"{S[dcl]\\NP}/{S[adj]\\NP}",
		"{{{S[b]\\NP}/PP}/PP}/NP",
		"{{S/S}\\{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{S[b]\\NP}\\NP}/{S[adj]\\NP}",
		"{S[dcl]\\S}/{S[b]\\NP}",
		"{PP/{S[pss]\\NP}}/NP",
		":",
		"{S[dcl]/{S[b]\\NP}}/NP",
		";",
		"{{N/N}\\{N/N}}/N[num]",
		"N\\N",
		"{{S/S}\\NP}/{S[ng]\\NP}",
		"S[pss]/{S[to]\\NP}",
		"{S[q]/{S[to]\\NP}}/NP",
		"{S[b]\\NP}/S[pss]",
		"{{S\\NP}\\{S\\NP}}/S[poss]",
		"{S[dcl]\\NP}/S[em]",
		"{S/S}/N[num]",
		"{{NP\\NP}/{S[dcl]\\N}}/N",
		"N/S[for]",
		"{NP\\NP}/N[num]",
		"N",
		"{S[dcl]/S[ng]}/NP",
		"{S[pss]\\NP}/S[dcl]",
		"S",
		"{{S/S}/S[dcl]}/{S[asup]\\NP}",
		"S[frg]/S[qem]",
		"{{{S[b]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]",
		"{{S/S}/{S[to]\\NP}}/NP[thr]",
		"{{{S[b]\\NP}/PP}/{S[adj]\\NP}}/NP",
		"{{{N/N}/{N/N}}\\{{N/N}/{N/N}}}/{{N/N}/{N/N}}",
		"{S\\S}/NP",
		"{S[pt]\\NP}/S[em]",
		"{{{S\\S}\\{S\\S}}\\{{S\\S}\\{S\\S}}}/S[dcl]",
		"{{S[dcl]\\NP}/NP}/NP",
		"{{S[dcl]\\NP}/S[q]}/NP",
		"S[em]/PP",
		"{{S[ng]\\NP}/PP}/S[intj]",
		"S[dcl]/{S[pt]\\NP}",
		"{{S/S}\\NP}/S[dcl]",
		"{{S[b]\\NP}/{S[ng]\\NP}}/{S[adj]\\NP}",
		"{{S[pt]\\NP}/{S[b]\\NP}}/NP",
		"{{S[dcl]\\NP[expl]}/S[dcl]}/{S[adj]\\NP}",
		"{{S[dcl]\\NP}/S[b]}/NP",
		"{S[dcl]\\NP}/S[b]",
		"N/{S[adj]\\NP}",
		"{NP/NP}/{S[adj]\\NP}",
		"{{S[dcl]\\NP[thr]}/{S[pss]\\NP}}/NP",
		"{{S[b]\\NP}\\NP}/{S[b]\\NP}",
		"{{S\\NP}\\{S\\NP}}/{S[b]\\NP}",
		"{S[adj]\\NP}/NP",
		"{S/S}/N",
		"{{S[dcl]\\S[dcl]}\\S[dcl]}/NP",
		"S[wq]/{S[dcl]/NP}",
		"{S[to]\\NP}/NP",
		"{{S/S}/{S[adj]\\NP}}/NP",
		"{S[adj]\\NP}/S[poss]",
		"{{S[b]\\NP}/NP}/{S[to]\\NP}",
		"{S[q]/{S[pt]\\NP}}/NP",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[ng]\\NP}",
		"{{{N/N}\\{N/N}}\\{{N/N}\\{N/N}}}/N",
		"{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}/N[num]",
		"{S[pt]\\NP}/S[adj]",
		"{S[q]/{S[pss]\\NP}}/NP",
		"S/{S[adj]\\NP}",
		"{{S[dcl]\\S[q]}\\NP}/S[dcl]",
		"{{{S[dcl]\\S[dcl]}\\NP}/S[q]}/PP",
		"{S[pt]/S[dcl]}/NP",
		"{{S[dcl]\\S[dcl]}/S[dcl]}/NP",
		"{S[dcl]\\NP}/{S[b]\\NP}",
		"{{S[pss]\\NP}/S[em]}/PP",
		"{{S[dcl]\\NP}/NP}/PP",
		"{S[dcl]\\S[wq]}\\NP",
		"{{S/S}\\{S/S}}/{{S/S}\\{S/S}}",
		"{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}",
		"{S[b]/{S[pt]\\NP}}/NP",
		"{S[pt]\\NP}/S[for]",
		"{{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}\\{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}}/N",
		"{NP\\NP}/S[q]",
		"{S[dcl]\\NP}\\{S[adj]\\NP}",
		"{{{S[dcl]\\NP}/{S[to]\\NP}}/PP}/NP[expl]",
		"{PP/PP}/{S[asup]\\NP}",
		"{{S[dcl]\\NP[expl]}/S}/PP",
		"{S[adj]\\NP}/PP",
		"{{S[b]\\NP}\\NP}/PP",
		"{N/N}/S[dcl]",
		"{N\\N}/{S[dcl]\\NP}",
		"{{NP\\NP}/S[pt]}\\{{NP\\NP}/NP}",
		"{{NP\\NP}/{S[to]\\NP}}/NP",
		"{S[pss]\\NP}/S[qem]",
		"{S[dcl]\\PP}/NP",
		"{{S[pss]\\NP}/{S[to]\\NP}}/{PP/NP}",
		"{S[dcl]\\NP}/S[to]",
		"S[dcl]/S[dcl]",
		"S[frg]/S",
		"S[frg]/N",
		"{{S\\S}/{S[to]\\N}}/N",
		"{{NP\\NP}/PP}/{{NP\\NP}/PP}",
		"{{{S[pt]\\NP}/NP}/{S[adj]\\NP}}/NP",
		"{{S[b]\\NP}/{S[to]\\NP}}/PP",
		"{{S\\NP}\\{S\\NP}}/S[em]",
		"{S[ng]\\NP}/S[for]",
		"{{S[pss]\\NP}/{S[ng]\\NP}}/NP",
		"{{S\\S}/{S\\S}}/{S[adj]\\NP}",
		"{N/N}/{S[adj]\\NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[b]\\NP}",
		"{NP\\NP}/{S[asup]\\NP}",
		"{{{S[dcl]\\NP}/PP}/PP}/NP",
		"S[b]\\NP",
		"{{N/N}/{N/N}}/{{N/N}/{N/N}}",
		"S[to]/{S[b]\\NP}",
		"NP/{{S[to]\\NP}/NP}",
		"{{{S[dcl]\\S[dcl]}\\NP}/PP}/NP",
		"{{NP\\NP}\\{NP\\NP}}/S[dcl]",
		"{{S[dcl]\\NP[expl]}/{S[ng]\\NP}}/NP",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{S\\NP}\\{S\\NP}}",
		"{{S[b]\\NP}/S[em]}/{S[to]\\NP}",
		"S[qem]/{S[dcl]/NP}",
		"{PP\\PP}/PP",
		"{{S/S}\\{S/S}}/S[dcl]",
		"{{NP/NP}/S[dcl]}/{S[adj]\\NP}",
		"{S/S}/NP",
		"{N\\N}/{S[adj]\\NP}",
		"{{S[dcl]\\S[qem]}\\NP}/{S[b]\\NP}",
		"{{S[b]\\NP}/PP}/{S[adj]\\NP}",
		"{{S\\{S\\NP}}\\{S\\{S\\NP}}}/NP",
		"{{S[adj]\\NP}/{S[adj]\\NP}}/NP",
		"{S[dcl]/NP}/{S[pss]\\NP}",
		"{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}",
		"{{S/S}/{S[pss]\\NP}}/NP",
		"{{S[qem]/{S[dcl]/NP}}/N}/{S[adj]\\NP}",
		"{S[b]\\NP}/{PP/NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{S[dcl]\\{S[b]\\NP}}\\NP}/NP",
		"{S[dcl]\\{S[adj]\\NP}}/{S[to]\\NP}",
		"{S[dcl]\\S[qem]}/{S[adj]\\NP}",
		"{PP/PP}/NP",
		"{{S[dcl]\\NP}/{S[adj]\\NP}}/PP",
		"{S[qem]/{S[pt]\\NP}}/NP",
		"{S[pt]\\NP}/S",
		"{S[pt]\\NP}/S[dcl]",
		"{N/N}/S[frg]",
		"{{NP/NP}/{NP/NP}}/{S[adj]\\NP}",
		"S[wq]/{S[q]/NP}",
		"{{S[dcl]\\NP}/S}/{S[to]\\NP}",
		"{{S[dcl]\\NP}/S[qem]}/NP",
		"{S[pt]\\S[dcl]}/NP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/PP",
		"{N/N}/S[qem]",
		"{S/{S[to]\\NP}}/NP",
		"{{S[ng]\\NP}/{S[to]\\NP}}/{S[to]\\NP}",
		"{{S/S}\\{S/S}}/{S[adj]\\NP}",
		"{S[dcl]\\NP[expl]}/{S[pss]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/S[dcl]}/N",
		"{{S[b]\\NP}/S[q]}/NP",
		"{S[b]\\NP}/NP",
		"{{{S\\NP}\\{S\\NP}}/{S[to]\\NP}}/NP",
		"{{S[q]/S[dcl]}/{S[b]\\NP}}/NP",
		"{{NP\\NP}/{NP\\NP}}/N",
		"{PP/{S[ng]\\NP}}/NP",
		"{S\\S}/N",
		"{{NP\\NP}/{{S[to]\\NP}/NP}}/NP",
		"{S[dcl]\\NP[thr]}/{S[to]\\NP}",
		"{S/S}/{S[to]\\NP}",
		"{N\\N}/{S[ng]\\NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[pss]\\NP}",
		"{PP\\PP}/N[num]",
		"S[poss]/{S[to]\\NP}",
		"{{S[b]\\NP}\\NP}/NP",
		"{{S[dcl]\\{S[adj]\\NP}}\\NP[expl]}/{S[to]\\NP}",
		"N/{S[dcl]/NP}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[ng]\\NP}",
		"{{S[dcl]\\NP}/S[qem]}/PP",
		"{N/N}/{S[asup]\\NP}",
		"{S[ng]\\NP}/S[bem]",
		"{S[wq]/NP}/NP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/NP",
		"{{S[dcl]\\NP}/{S[pss]\\NP}}/NP",
		"{{S[ng]\\NP}/NP}/PP",
		"{S[b]\\NP}/S[wq]",
		"{S/S}\\{S/S}",
		"{{NP/NP}/{NP/NP}}/{S[asup]\\NP}",
		"{S[b]\\NP}/PP",
		"{S[wq]/S[q]}\\{{NP\\NP}/NP}",
		"{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/PP",
		"{S/{S[pt]\\NP}}/NP",
		"{{S[dcl]\\NP[expl]}/S[qem]}/{S[adj]\\NP}",
		"{NP\\NP}/{S[q]/NP}",
		"{{S[dcl]\\S[dcl]}\\NP}/S[em]",
		"{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}/{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}",
		"{{NP\\NP}\\{NP\\NP}}/N",
		"{{S[dcl]\\NP}/S[em]}/{S[adj]\\NP}",
		"{{NP\\NP}\\NP}/{S[to]\\NP}",
		"{S[q]/S[em]}/NP",
		"{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}\\{S[adj]\\NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}\\NP",
		"S/{S[ng]\\NP}",
		"{S[dcl]\\S[em]}/NP",
		"{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}",
		"{S[dcl]\\S[pss]}/NP",
		"{{{S[dcl]\\NP}/{S[dcl]\\NP}}/NP}/NP",
		"{{S[dcl]\\NP[expl]}/S[bem]}/{S[adj]\\NP}",
		"{S[dcl]\\NP[thr]}/{S[ng]\\NP}",
		"{{S[dcl]\\NP}/PP}/{S[ng]\\NP}",
		"{S[dcl]\\NP}/S[dcl]",
		"{{S[dcl]\\NP}/NP}/S[dcl]",
		"{{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}}/{{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}}",
		"{{S/S}/{S/S}}/{{S/S}/{S/S}}",
		"{{{S[ng]\\NP}\\{S[adj]\\NP}}/PP}/NP",
		"{S[dcl]\\NP}/{S[pss]\\NP}",
		"{{S\\NP}\\{S\\NP}}/S",
		"{{S[dcl]\\S[dcl]}\\NP}/{S[pt]\\NP}",
		"{{{S[dcl]\\NP}/S[dcl]}/{S[adj]\\NP}}/NP[expl]",
		"{S\\S}/{S[asup]\\NP}",
		"{{{S[dcl]\\NP}\\{S[adj]\\NP}}/S[em]}/NP",
		"{S[dcl]\\S[wq]}/NP",
		"{{{S\\NP}\\{S\\NP}}/{S[dcl]\\NP}}\\{NP/NP}",
		"{{{S\\NP}\\{S\\NP}}/PP}/NP",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{S[asup]\\NP}",
		"{S[q]/{S[pt]\\NP}}/NP[expl]",
		"{{{S[b]\\NP}/NP}/{S[adj]\\NP}}/NP",
		"{{{S[ng]\\NP}/{S[to]\\NP}}/PP}/NP",
		"{{NP/NP}/{NP/NP}}\\{S[adj]\\NP}",
		"{N/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}",
		"NP[nb]/N",
		"{{S[dcl]\\{S[adj]\\NP}}\\NP}/NP",
		"{{S[adj]\\NP}/S[qem]}\\NP",
		"{S[dcl]\\NP}/S[q]",
		"{{S[b]\\NP}/{S[ng]\\NP}}/NP",
		"NP",
		"{{{S[adj]\\NP}/PP}/PP}/NP",
		"{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/NP",
		"{S[dcl]/NP}/NP[thr]",
		"{{{NP\\NP}/S[dcl]}\\{{NP\\NP}/NP}}/N",
		"{S[inv]/{S[ng]\\NP}}/NP",
		"{{NP\\NP}\\{NP\\NP}}/{S[adj]\\NP}",
		"{{NP/NP}\\{NP/NP}}/N",
		"{S[dcl]\\NP[thr]}/NP",
		"{S[ng]\\NP}/S",
		"{{NP\\NP}/{S[dcl]/NP}}\\{NP/NP}",
		"{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/S[dcl]",
		"S[b]/NP",
		"{NP\\NP}/{S[pss]\\NP}",
		"{S[ng]\\NP}/S[b]",
		"{S\\NP}/N",
		"{{{S[dcl]/S[dcl]}\\NP}/S[em]}/NP",
		"{NP\\NP}/{S[dcl]\\NP}",
		"NP/S[dcl]",
		"{PP/PP}/PP",
		"{{S[dcl]\\NP}/{{S[to]\\NP}/NP}}/{S[adj]\\NP}",
		"{{S[qem]/S[dcl]}/{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{{NP\\NP}/{S[dcl]\\NP}}\\{NP/NP}}/N",
		"{{S[dcl]\\NP}/{S[adj]\\NP}}/NP",
		"{{NP[nb]/N}/PP}/{S[adj]\\NP}",
		"{S\\S}/{S\\S}",
		"{{S\\NP}\\{S\\NP}}/N",
		"{S[dcl]\\S[em]}/PP",
		"{{NP/NP}/{NP/NP}}/{{NP/NP}/{NP/NP}}",
		"{{S[ng]\\NP}/{S[pss]\\NP}}/NP",
		"{{S[b]\\NP}/PP}/S[intj]",
		"{S[dcl]\\NP}/{S[dcl]\\NP}",
		"{{{S[dcl]\\NP[expl]}/{NP\\NP}}/NP}/{S[adj]\\NP}",
		"{S[pss]\\NP}/{PP/NP}",
		"{S[dcl]\\NP}/S",
		"{S[inv]/{S[adj]\\NP}}/NP",
		"{{{S[dcl]\\NP}/S[em]}/NP}/NP",
		"{{{S\\NP}\\{S\\NP}}/PP}/PP",
		"{S[to]\\NP}/{S[ng]\\NP}",
		"{S[q]/{S[b]\\NP}}/NP",
		"{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[pt]",
		"{{{S\\NP}\\{S\\NP}}/{S[pt]\\NP}}/NP",
		"S[em]",
		"{{{S\\NP}\\{S\\NP}}\\PP}/{{{S\\NP}\\{S\\NP}}\\PP}",
		"{{{S[pt]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]",
		"{{S[ng]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}",
		"{S[b]\\NP}/{S[to]\\NP}",
		"{S\\S}/{S[b]\\NP}",
		"{{S[adj]\\NP}/S[em]}/{S[adj]\\NP}",
		"{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/PP}/{S[adj]\\NP}",
		"{S[b]\\NP}/{S[dcl]\\NP}",
		"{{S\\S}\\{S\\S}}/{{S\\S}\\{S\\S}}",
		"PP",
		"conj/conj",
		"{S[dcl]\\S[em]}/{S[b]\\NP}",
		"S/{S[dcl]\\NP}",
		"{{S[ng]\\NP}/NP}/{S[adj]\\NP}",
		"{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}",
		"{S[b]\\NP}/S[poss]",
		"{{S\\NP}\\{S\\NP}}\\{{NP\\NP}/NP}",
		"{{S[dcl]\\PP}/NP}/{S[ng]\\NP}",
		"{S/S}/S[ng]",
		"N/{S[dcl]\\NP}",
		"{S[dcl]\\NP}/S[as]",
		"N/S[b]",
		"{{S/S}/{S[dcl]/N}}/N",
		"{{S[b]\\NP}/{PP/NP}}/NP",
		"NP[thr]",
		"{{NP\\NP}/{S[dcl]\\NP}}\\{NP/NP}",
		"{{S\\NP}/{S\\NP}}/{S[b]\\NP}",
		"{N\\N}/S[dcl]",
		"S[ng]\\NP",
		"{{S\\NP}/{S\\NP}}/S[frg]",
		"{{S\\S}/NP}/NP",
		"{S[b]\\NP}/S[b]",
		"{{NP\\NP}\\{{NP\\NP}/NP}}/N",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}}/{{S[adj]\\NP}/{S[adj]\\NP}}",
		"{{S[dcl]\\NP}/{{S[to]\\NP}/NP}}/NP",
		"{S[q]/PP}/NP",
		"{S[wq]/S[q]}/{S[adj]\\NP}",
		"{S[b]\\NP}/{S[adj]\\NP}",
		"{{S[b]\\NP}/{{S[to]\\NP}/NP}}/NP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S[poss]",
		"{NP\\NP}/S[poss]",
		"{S[ng]\\NP}/S[em]",
		"{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}",
		"{{S\\NP}/{S\\NP}}/{S[adj]\\NP}",
		"{S[q]/{S[ng]\\NP}}/NP",
		"{{S[adj]\\NP}/{S[adj]\\NP}}/S[dcl]",
		"{{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}\\{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}}/NP",
		"{{S[dcl]\\NP}\\NP}/{S[to]\\NP}",
		"{S/{S[b]\\NP}}/NP",
		"{{S\\S}/{S[b]\\NP}}/NP",
		"{{S[dcl]/S[dcl]}\\NP}/S[dcl]",
		"{NP/NP}\\{NP/NP}",
		"{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}/NP",
		"{{S\\S}\\NP}/{S[b]\\NP}",
		"{{S[ng]\\NP}/{S[adj]\\NP}}/NP",
		"{S[dcl]/PP}/NP",
		"{PP/PP}/{PP/PP}",
		"{S[ng]\\NP}/S[dcl]",
		"{S\\NP}/{S\\NP}",
		"{{S[dcl]\\NP}/{S[pt]\\NP}}/NP",
		"{{NP[nb]/N}\\{NP[nb]/N}}/{NP[nb]/N}",
		"{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}",
		"{{S\\S}/{S[to]\\NP}}/NP",
		"S[wq]/{S[adj]\\NP}",
		"{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/{S[adj]\\NP}",
		"{S[dcl]\\PP}/S[qem]",
		"{NP[nb]/N}/PP",
		"{{NP/NP}\\{NP/NP}}/{NP/NP}",
		"{{NP\\NP}\\{NP\\NP}}\\NP",
		"{S[dcl]\\S[qem]}/S[em]",
		"{S/S}\\NP",
		"{S[q]/{S[adj]\\NP}}/NP[expl]",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/NP",
		"S[frg]/PP",
		"{S[dcl]\\{S[b]\\NP}}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/NP",
		"{S[dcl]\\{S[dcl]\\NP}}\\NP",
		"{S[adj]\\S[adj]}/NP",
		"S[wq]/S[q]",
		"S[wq]/PP",
		"{{S[qem]/{S[dcl]\\NP}}/N}/{S[adj]\\NP}",
		"{S[dcl]\\S[qem]}/NP",
		"{{N/N}\\{N/N}}/{{N/N}\\{N/N}}",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/N",
		"{{S[b]\\NP}/S[poss]}/NP",
		"{S[dcl]\\S[dcl]}\\NP",
		"{{S/S}/{S/S}}/{S[asup]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/NP}/NP",
		"{S[dcl]\\{S[adj]\\NP}}\\NP",
		"NP[expl]",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}",
		"{S[qem]/{{S[b]\\NP}/NP}}/NP",
		"{{S[adj]\\NP}/PP}\\NP",
		"{{{S\\NP}\\{S\\NP}}\\{{NP\\NP}/NP}}/N",
		"S/{{S[to]\\NP}/NP}",
		"{{S[b]\\NP}/{S[adj]\\NP}}/NP",
		"{S\\NP}/N[num]",
		"{{S/S}/{S[ng]\\NP}}/NP",
		"{NP\\NP}/S[b]",
		"{{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}}/{{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}}",
		"{{{S[dcl]\\NP}/{S[adj]\\NP}}/PP}/NP",
		"S[dcl]/{S[pss]\\NP}",
		"{{S[ng]\\NP}/{S[adj]\\NP}}/PP",
		"{S[b]\\S[dcl]}\\NP",
		"{S[dcl]\\NP}/S[pt]",
		"{{{S[dcl]\\NP}/{S[adj]\\NP}}/PP}/PP",
		"{{S[pt]\\NP}/S[bem]}/PP",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[dcl]\\NP}",
		"{NP/NP}/NP",
		"{S[pt]\\NP}/{S[pt]\\NP}",
		"{NP\\NP}/S[adj]",
		"{{{S[b]\\NP}/S[dcl]}/{S[adj]\\NP}}/NP",
		"{{{S[ng]\\NP}/{S[ng]\\NP}}/{S[ng]\\NP}}/NP",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[b]\\NP}}/NP",
		"{S[b]\\NP}/S[bem]",
		"{{S\\NP}/{S\\NP}}/{S[pss]\\NP}",
		"{S[dcl]\\S[qem]}/PP",
		"{S[dcl]\\{S[to]\\NP}}/{S[to]\\NP}",
		"N[num]",
		"{{NP\\NP}\\{NP\\NP}}/N[num]",
		"{{S[b]\\NP}/S[em]}/NP",
		"{S[pt]\\NP}/S[qem]",
		"{{{{S\\NP}\\{S\\NP}}\\NP}/{S[to]\\NP}}/NP",
		"{{{S[dcl]\\NP}/S[em]}/PP}/NP[expl]",
		"{{S[adj]\\NP}/{S[adj]\\NP}}\\{S[adj]\\NP}",
		"{NP\\NP}/{S[b]/NP}",
		"{{S[to]\\NP}/{S[to]\\NP}}/{S[b]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[asup]\\NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S[pss]",
		"{{{S\\NP}\\{S\\NP}}\\PP}\\{S[adj]\\NP}",
		"N/N",
		"{PP\\PP}/{PP\\PP}",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/N",
		"{{N/N}/{N/N}}/{S[adj]\\NP}",
		"{N/N}/N[num]",
		"{S\\S}/{S[pss]\\NP}",
		"N/S",
		"{S[dcl]\\{S[to]\\NP}}/{S[b]\\NP}",
		"{S[pss]\\NP}/S[for]",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[ng]\\NP}",
		"{S/S}/PP",
		"{S[dcl]\\{S[b]\\NP}}\\NP",
		"{{S[b]\\NP}\\NP}/S[em]",
		"{S[adj]\\S[adj]}/S[dcl]",
		"{{S/S}/PP}/NP",
		"{S[ng]\\NP}/S[qem]",
		"{{{S[pt]\\NP}/S[dcl]}/PP}/NP",
		"{NP/NP}/PP",
		"{{S\\NP}\\{S\\NP}}/{S[adj]\\NP}",
		"{{S[b]\\NP}/NP}/",
		"{{S[dcl]\\NP}/S[qem]}/{S[adj]\\NP}",
		"{S[adj]\\NP}/S[em]",
		"{{{S[b]\\NP}/{S[to]\\NP}}/NP}/NP",
		"{S[qem]/S[dcl]}/{S[adj]\\NP}",
		"{{{S[dcl]\\NP}/{S[to]\\NP}}/PP}/{S[adj]\\NP}",
		"{S[adj]\\NP}/N[num]",
		"N/N[num]",
		"{{NP\\NP}\\{{NP\\NP}/NP}}/{S[dcl]\\NP}",
		"conj/PP",
		"{PP\\PP}/{S[adj]\\NP}",
		"{{NP\\NP}\\S[dcl]}/NP",
		"{{{S[ng]\\NP}/PP}/{S[adj]\\NP}}/NP",
		"{{S/S}/{S[pt]\\NP}}/NP",
		"S[to]\\{S[to]\\NP}",
		"{{S[dcl]\\NP[thr]}/S[dcl]}/NP",
		"{{S[b]\\NP}/S[em]}/PP",
		"{S[dcl]\\S[qem]}\\NP",
		"S/S[em]",
		"{S[dcl]/{S[adj]\\NP}}/NP",
		"{PP/{S[to]\\NP}}/NP",
		"{S[adj]\\NP}/{S[adj]\\NP}",
		"{{S[adj]\\NP}/PP}/{S[to]\\NP}",
		"S\\S",
		"S[dcl]/{S[to]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\NP}/{S[ng]\\NP}",
		"{{{S[dcl]\\NP}/NP}/{S[adj]\\NP}}/NP[expl]",
		"{{S[adj]\\NP}/{S[adj]\\NP}}/{S[asup]\\NP}",
		"{{S[b]\\NP}/PP}/NP",
		"{NP\\NP}/S[dcl]",
		"{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/{S[asup]\\NP}",
		"NP/{S[dcl]\\NP}",
		"{N\\N}/NP",
		"{S[dcl]\\{S[b]\\NP}}/NP",
		"{{NP\\NP}/{S[dcl]/N}}/N",
		"{{{S[b]\\NP}/S[for]}/{S[adj]\\NP}}/NP[expl]",
		"{{{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}}\\NP}/{S[to]\\NP}",
		"{{NP\\NP}\\{NP\\NP}}/{S[dcl]\\NP}",
		"{{S[ng]\\NP}/{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{S[ng]\\NP}/{S[to]\\NP}}/PP",
		"{{S/S}/{S/S}}/NP",
		"{{NP\\NP}\\{NP\\NP}}/PP",
		"{NP[nb]/N}\\NP",
		"{NP/NP}/S[dcl]",
		"{S[dcl]\\{S[ng]\\NP}}/{S[pt]\\NP}",
		"{S[pss]\\NP}\\{S[adj]\\NP}",
		"{S\\S}/S[dcl]",
		"{{S[b]\\NP}/{S[pss]\\NP}}/NP",
		"{{S[pss]\\NP}/PP}/NP",
		"{{NP\\NP}/{NP\\NP}}/{S[ng]\\NP}",
		"{{S[dcl]\\NP}/{S[ng]\\NP}}/NP",
		"{PP\\PP}/NP",
		"{{S[pt]\\NP}/S[qem]}/NP",
		"S[dcl]\\NP[thr]",
		"{{{NP\\NP}/PP}/PP}/NP",
		"{S\\S}/{S[adj]\\NP}",
		"{{S/S}/{S/S}}/{S[adj]\\NP}",
		"{S[dcl]\\NP}/S[ng]",
		"{{{S[pt]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]",
		"{{{S[pt]\\NP}/{S[to]\\NP}}/PP}/NP",
		"{{N/N}\\NP}/N[num]",
		"S[wq]/{S[b]/NP}",
		"{{N/N}\\{N/N}}/{S[dcl]\\NP}",
		"{S[pt]\\NP}/{S[ng]\\NP}",
		"{{S[b]\\NP}/{S[pt]\\NP}}/NP",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}}/NP",
		"S[em]/S[b]",
		"{{S/S}\\{S/S}}/N",
		"{S[dcl]\\S[for]}/NP",
		"{{S\\NP}\\{S\\NP}}\\PP",
		"{S[dcl]\\S[qem]}/{S[pt]\\NP}",
		"N/S[em]",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}",
		"{S[inv]/NP}/NP[thr]",
		"{S[b]\\NP}/S[qem]",
		"{N\\N}/{N\\N}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S[dcl]",
		"{S[dcl]\\NP}/S[pss]",
		"{S[dcl]\\{S[dcl]\\NP}}/NP",
		"{{S[dcl]\\S[dcl]}/{S[ng]\\NP}}/NP",
		"{{S[adj]\\NP}/PP}/PP",
		"{N\\N}/{S[pss]\\NP}",
		"{{S[adj]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}",
		"S[qem]/S[dcl]",
		"S[dcl]/S[inv]",
		"{{S[b]\\NP}/PP}/PP",
		"{PP/NP}/{PP/NP}",
		"{S[dcl]\\S}/NP",
		"{{{{S[b]\\NP}/PP}/PP}/{S[adj]\\NP}}/NP",
		"{S[inv]/{S[b]\\NP}}/NP",
		"{{NP\\NP}\\{NP\\NP}}/NP",
		"{{:\\NP}/PP}/NP",
		"{{S[pss]\\NP}/PP}/PP",
		"{{S[dcl]\\NP}/S[wq]}/S[qem]",
		"{NP/NP}\\{S[adj]\\NP}",
		"{PP/{S[b]\\NP}}/NP",
		"{S[dcl]\\NP}/{S[ng]\\NP}",
		"S[pt]\\NP",
		"{{N/N}/PP}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\NP}/NP",
		"{{PP\\PP}\\{PP\\PP}}/{S[dcl]\\NP}",
		"{S/S}/{S[b]\\NP}",
		"{{S[adj]\\NP}/{{S[to]\\NP}/NP}}/{S[adj]\\NP}",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/NP",
		"{{S[b]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}",
		"{NP/NP}\\NP",
		"{{{S[dcl]\\NP}/{S[to]\\NP}}/PP}/NP",
		"S[em]/NP",
		"N\\N[num]",
		"{{NP\\NP}/{S[to]\\NP}}\\{{NP\\NP}/NP}",
		"{S\\S}/PP",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[adj]\\NP}",
		"S[em]/S",
		"{NP\\NP}/{S[to]\\NP}",
		"{{S[b]\\NP}/S}/NP",
		"{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}/N",
		"{{S\\NP}/{S[dcl]\\N}}/N",
		"{{S[adj]\\NP}/PP}/NP",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{S[adj]\\NP}\\{S[adj]\\NP}}",
		"{{{S[dcl]\\NP}/S[for]}/NP}/NP[expl]",
		"{{S\\NP}/{S\\NP}}/S[dcl]",
		"{S/S}/{S[adj]\\NP}",
		"{{N/N}\\{N/N}}/{N/N}",
		"{S\\S}/S[frg]",
		"{{{S\\NP}\\{S\\NP}}\\NP}/{S[b]\\NP}",
		"{{{S[b]\\NP}/{S[b]\\NP}}/{S[b]\\NP}}/NP",
		"{{S[dcl]\\NP}/{S[b]\\NP}}/NP",
		"S[frg]/NP",
		"{{S[ng]\\NP}/S[em]}/{S[adj]\\NP}",
		"{{S[adj]\\NP}/S[em]}/PP",
		"{{S\\NP}\\{S\\NP}}/S[adj]",
		"{{{S[ng]\\NP}/S[for]}/{S[adj]\\NP}}/NP[expl]",
		"S[wq]/NP",
		"S[pss]\\NP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S[inv]",
		"{S[qem]/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}",
		"{{S[qem]/S[wq]}/{S[dcl]/N}}/N",
		"{S\\S}/{S[ng]\\NP}",
		"{S[b]\\NP}/S[as]",
		"{S[em]\\NP}/{S[b]\\NP}",
		"{{S\\NP}\\{S\\NP}}/S[for]",
		"{S[q]/S}/NP",
		"{S[b]\\NP}/S",
		"PP/S[wq]",
		"{{S[adj]\\NP}\\NP}/S[em]",
		"{{S[pt]\\NP}/S}/NP",
		"{{S[pt]\\NP}/NP}/{S[dcl]\\NP}",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}/NP}/N",
		"{{{S\\NP}\\{S\\NP}}\\NP}/PP",
		"{S[dcl]\\S[em]}/S[qem]",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/PP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S[frg]",
		"{{S[pt]\\NP}/{{S[to]\\NP}/NP}}/NP",
		"{{{S[b]\\NP}/{S[to]\\NP}}/NP}/NP[expl]",
		"{S[ng]\\NP}/{S[to]\\NP}",
		"{{S[ng]\\NP}/PP}/{S[adj]\\NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S[qem]",
		"{S/S}/S[em]",
		"NP/{S[b]\\NP}",
		"{S[ng]\\NP}/S[q]",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[wq]",
		"{{S\\NP}/{S\\NP}}/{S[to]\\NP}",
		"{S[b]\\NP}/S[dcl]",
		"S[em]/S[frg]",
		"{{PP/NP}/{S[adj]\\NP}}/N",
		"{NP/{S[dcl]\\N}}/N",
		"{{S/S}/{S[to]\\N}}/N",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}",
		"{NP\\NP}/{S[dcl]/S[dcl]}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[b]\\NP}",
		"{S[ng]\\NP}/S[pss]",
		"{N/N}/N",
		"{S[em]/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}",
		"{{S[dcl]\\NP}/{S[ng]\\NP}}/S[em]",
		"{{S\\NP}/{S\\NP}}/PP",
		"{{S\\S}/{S\\S}}/S[dcl]",
		"PP/{S[adj]\\NP}",
		"{N/N}/NP",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}\\{S[adj]\\NP}",
		"{{S[ng]\\NP}/S[dcl]}/NP",
		"{{S/S}/{S/S}}/S[dcl]",
		"S[qem]/{S[dcl]\\NP}",
		"S[wq]/{S[b]\\NP}",
		"S[intj]",
		"{PP\\PP}/{S[b]\\NP}",
		"{{S[dcl]\\NP[expl]}/S[bem]}/PP",
		"{NP/PP}/N",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}",
		"{{S[pss]\\NP}\\NP}/{S[pt]\\NP}",
		"S[wq]/{S[dcl]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/S[dcl]",
		"{{S[dcl]\\NP[thr]}/{S[ng]\\NP}}/NP",
		"{S/S}/S[frg]",
		"{{{N/N}/{N/N}}/PP}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\NP}/S",
		"{S/S}/S[qem]",
		"{NP\\NP}/PP",
		"{{S[dcl]\\NP[expl]}/S}/{S[adj]\\NP}",
		"{NP\\NP}/S[wq]",
		"{S/S}/{S[pss]\\NP}",
		"{NP/{S[dcl]/N}}/N",
		"{{S[pt]\\NP}/S[em]}/PP",
		"{{S[pt]\\NP}/PP}/PP",
		"{S[em]\\NP}/S[dcl]",
		"{S[qem]/S[dcl]}/N",
		"{{{S\\NP}/{S\\NP}}\\{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{S[b]\\NP}/S[for]}/NP",
		"{S/S}/S[inv]",
		"{{NP\\NP}/{NP\\NP}}/{S[asup]\\NP}",
		"{N\\N}/{S[b]\\NP}",
		"{S[dcl]\\NP}/{S[to]\\NP}",
		"{{S[dcl]\\NP}/S[dcl]}/{S[adj]\\NP}",
		"{S[dcl]\\{S[adj]\\NP}}/S[qem]",
		"{{NP\\NP}/NP}/{S[adj]\\NP}",
		"{{S/S}/S[dcl]}/{S[adj]\\NP}",
		"{{NP\\NP}\\NP}/PP",
		"{S[dcl]\\NP}/S[wq]",
		"{S\\S}/{S[dcl]\\NP}",
		"{{S\\NP}\\{S\\NP}}/PP",
		"{N/N}/PP",
		"{NP\\NP}/S[pss]",
		"{{S\\NP}/{S\\NP}}/NP",
		"{{{S[b]\\NP}/{{S[to]\\NP}/NP}}/NP}/NP",
		"{{S/S}/NP}/NP",
		"{{S[pss]\\NP}/S[qem]}/{S[to]\\NP}",
		"{{{S[pt]\\NP}/PP}/PP}/NP",
		"{{S[dcl]\\{S[adj]\\NP}}/NP}/{S[b]\\NP}",
		"{{S[b]\\NP}/S[dcl]}/{S[adj]\\NP}",
		"{{S[pt]\\NP}/S[for]}/NP",
		"{{{S[ng]\\NP}/{S[to]\\NP}}/NP}/NP",
		"{{S[dcl]\\S[dcl]}/PP}/NP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[to]\\NP}",
		"{{NP\\NP}/N}\\NP",
		"{S[wq]/{S[dcl]/N}}/N",
		"{S[adj]\\NP}/N",
		"{{S[dcl]\\NP}/PP}/{S[to]\\NP}",
		"{PP\\PP}/{S[ng]\\NP}",
		"S[wq]/{S[q]/{S[adj]\\NP}}",
		"{{S/S}/{S[to]\\NP}}/NP",
		"{N/N}/{S[b]\\NP}",
		"{S[adj]\\NP}/S",
		"{S[q]/NP}/NP",
		"{NP\\NP}/NP",
		"{{S/S}/NP}/{S[adj]\\NP}",
		"{{S[ng]\\NP}/S[dcl]}/PP",
		"{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}",
		"{{{S\\NP}\\{S\\NP}}/{S[to]\\NP}}/N",
		"{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}\\NP",
		"{{S\\NP}/{S\\NP}}/{S[dcl]\\NP}",
		"{S[for]/{{S[to]\\NP}/NP}}/NP",
		"{{{S[ng]\\NP}/PP}/PP}/NP",
		"S[em]/S[dcl]",
		"S[adj]\\NP",
		"PP/S[intj]",
		"{{S[dcl]\\S[dcl]}\\NP}/{S[adj]\\NP}",
		"{{S[ng]\\NP}/PP}/{S[to]\\NP}",
		"{S[b]\\NP}/S[ng]",
		"{{S\\NP}/{S\\NP}}/{S[pt]\\NP}",
		"{S[ng]\\NP}/{S[dcl]\\NP}",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}",
		"S[b]",
		"{{S[b]\\NP}/S[dcl]}/NP",
		"{{N\\N}\\{N\\N}}/NP",
		"{{S\\NP}\\{S\\NP}}/{S[pt]\\NP}",
		"{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}/NP",
		"{S[dcl]\\{S[to]\\NP}}/NP",
		"{{NP\\NP}/{{S[b]\\NP}/NP}}/NP",
		"{{S[dcl]\\S[dcl]}\\NP}/PP",
		"{PP/N}\\NP",
		"NP\\N",
		"{{S[dcl]\\NP}/NP}/{S[adj]\\NP}",
		"{S/S}/{S[dcl]/S[dcl]}",
		"{{{S[pt]\\NP}/S[dcl]}/{S[adj]\\NP}}/NP[expl]",
		"{{NP\\NP}/PP}/NP",
		"{{S/S}\\{S/S}}/NP",
		"{{S\\NP}\\{S\\NP}}\\NP",
		"PP/{S[pss]\\NP}",
		"{{NP\\NP}\\NP}/NP",
		"{{S[pt]\\NP}/S[dcl]}/NP",
		"{{S[to]\\NP}\\{S[adj]\\NP}}/{S[b]\\NP}",
		"{S[adj]\\NP}/{NP\\NP}",
		"{{N/N}/{N/N}}/NP",
		"{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}",
		"{{S[pss]\\NP}/PP}/{PP/NP}",
		"{{S\\NP}\\{S\\NP}}/S[pss]",
		"{{NP\\NP}/{NP\\NP}}/{{NP\\NP}/{NP\\NP}}",
		"{{S[dcl]\\S[dcl]}\\NP}/{S[b]\\NP}",
		"S[em]/S[wq]",
		"{N/N}/{S\\NP}",
		"{S\\NP}\\{S\\NP}",
		"{{S\\NP}\\{S\\NP}}/S[wq]",
		"{{S[b]\\NP}/NP}/{S[dcl]\\NP}",
		"{{S\\NP}/{S\\NP}}\\NP",
		"{S[adj]\\NP}\\{S[adj]\\NP}",
		"{N/{S[adj]\\NP}}/NP",
		"S[inv]/NP",
		"{S[dcl]/{S[pss]\\NP}}/NP",
		"PP/NP",
		"{{S[pt]\\NP}/S[em]}/{S[adj]\\NP}",
		"{{NP\\NP}\\NP}/S[dcl]",
		"{S[dcl]\\{S[pss]\\NP}}/{S[b]\\NP}",
		"{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}/NP",
		"{{S[dcl]\\NP}/{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/S[dcl]}\\{{NP\\NP}/NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[asup]\\NP}",
		"{S[dcl]\\{S[to]\\NP}}/PP",
		"{S/S}/{S[ng]\\NP}",
		"{{S[b]\\NP}/S[dcl]}/PP",
		"{{S[dcl]\\S[dcl]}\\NP}/NP",
		"{{S[to]\\NP}/NP}/{S[b]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/S[dcl]}/S[dcl]",
		"{S[wq]/S[dcl]}/{S[adj]\\NP}",
		"{{S/S}\\{S[adj]\\NP}}/S[dcl]",
		"{{S/S}\\{S/S}}/PP",
		"S/NP",
		"{S[q]\\S[dcl]}/NP",
		"{{S[dcl]\\NP[expl]}/S[bem]}/NP",
		"{{{S[ng]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]",
		"PP/PP",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[to]\\NP}",
		"{S[pss]\\NP}/{S[pt]\\NP}",
		"{{S[ng]\\NP}/{S[to]\\NP}}/NP",
		"S[as]/S[poss]",
		"{{{S[dcl]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]",
		"{N\\N}/PP",
		"{{N\\N}/{S[dcl]\\NP}}\\{NP/NP}",
		"{{S[adj]\\NP}\\NP}/{S[pss]\\NP}",
		"{{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}}\\{S[adj]\\NP}",
		"{{{S[dcl]\\NP[expl]}/S[q]}/S[qem]}/{S[to]\\NP}",
		"{{S[dcl]\\NP}/{S[ng]\\NP}}/PP",
		"{{S\\NP}\\{S\\NP}}/S[b]",
		"{N/N}\\NP",
		"{S[b]\\NP}/S[to]",
		"{{S\\S}\\{S\\S}}/N",
		"{S[dcl]\\S[qem]}/{S[b]\\NP}",
		"{{N/N}\\{N/N}}/N",
		"{N/{S[dcl]\\N}}/N",
		"{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[dcl]",
		"{{S[ng]\\NP}/{S[ng]\\NP}}/NP",
		"{S[q]/NP}/NP[thr]",
		"{{S[dcl]\\{S[b]\\NP}}\\NP}/{S[b]\\NP}",
		"{{S[dcl]\\NP}/{S[to]\\NP}}/NP",
		"{S[adj]\\NP}/{{S[to]\\NP}/NP}",
		"{{N/N}/{N/N}}/N[num]",
		"{S[dcl]\\{S[adj]\\NP}}/S[em]",
		"{{S[adj]\\NP}/{S[adj]\\NP}}/N",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S",
		"{{{{S\\NP}\\{S\\NP}}/S[dcl]}\\{{NP\\NP}/NP}}/N",
		"{{{S\\NP}/{S\\NP}}/{S[pss]\\NP}}/NP",
		"{S[wq]/PP}/N",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/N",
		"{S[pt]\\NP}/PP",
		"{{S[adj]\\NP}\\NP}/PP",
		"S[adj]/S[adj]",
		"{{{N/N}/{N/N}}/{{N/N}/{N/N}}}\\{S[adj]\\NP}",
		"{{S\\NP}\\{S\\NP}}/{S[ng]\\NP}",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}/PP}/NP",
		"{S[adj]\\NP}/{S[ng]\\NP}",
		"{S[dcl]\\NP}/{S[pt]\\NP}",
		"{S\\NP}/NP",
		"{{{S[dcl]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]",
		"{PP/NP}/NP",
		"{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}/{S[asup]\\NP}",
		"{S[dcl]\\NP[thr]}/{S[b]\\NP}",
		"{S[for]/{S[b]\\NP}}/NP",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}}/N",
		"{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/N",
		"{S[ng]\\NP}/{S[adj]\\NP}",
		"{{S/S}\\{S/S}}/{S[dcl]\\NP}",
		"{{N/N}\\{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{NP\\NP}\\NP}/{S[ng]\\NP}",
		"S/{S[to]\\NP}",
		"{NP\\NP}\\PP",
		"{NP/NP}/N",
		"{{S[dcl]/S[dcl]}\\NP}/{S[b]\\NP}",
		"{S/S}/S[pss]",
		"{{NP/NP}\\{NP/NP}}/{{NP/NP}\\{NP/NP}}",
		"{{S\\NP}/{S\\NP}}/S[pss]",
		"{S/S}/{S[dcl]/NP}",
		"{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[dcl]}\\{{NP\\NP}/NP}",
		"{NP\\NP}/S[inv]",
		"{N/S[dcl]}/{S[adj]\\NP}",
		"{{{S[b]\\NP}/{S[to]\\NP}}/PP}/NP",
		"{{S\\NP}\\{S\\NP}}/S[dcl]",
		"{S[dcl]/{S[to]\\NP}}/NP",
		"{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\NP}/NP",
		"{S[wq]/{S[dcl]\\N}}/N",
		"{{S[b]\\NP}/{S[adj]\\NP}}/PP",
		"{{S\\S}\\NP}/S[dcl]",
		"{NP\\NP}/{S[dcl]/NP}",
		"{{{S[ng]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]",
		"NP/{{S[dcl]\\NP}/NP}",
		"{{S[adj]\\NP}\\NP}/NP",
		"{NP\\NP}/S[qem]",
		"{{S[b]\\NP}/S[for]}/{S[adj]\\NP}",
		"{S[pt]\\NP}/NP",
		"{PP/PP}/S[dcl]",
		"NP/NP",
		"{{S[pt]\\NP}/NP}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\NP",
		"{S[dcl]\\{S[pss]\\NP}}/NP",
		"{PP\\PP}/N",
		"{{S[dcl]\\NP}\\NP}/{S[b]\\NP}",
		"{S[dcl]\\S[q]}\\NP",
		"{PP\\NP}/{S[ng]\\NP}",
		"S[adj]/NP",
		"{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/NP",
		"{S[b]\\NP}/S[for]",
		"{S\\S}/S[b]",
		"{S[dcl]\\{S[ng]\\NP}}/NP",
		"{{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}\\{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}}/NP",
		"{NP\\NP}\\NP",
		"conj\\conj",
		"{{{S/S}\\{S/S}}\\{{S/S}\\{S/S}}}/NP",
		"{S[b]/NP}/NP",
		"{S/PP}/{S[asup]\\NP}",
		"{S/S}/S[q]",
		"{S[ng]/PP}/NP",
		"{{NP\\NP}\\NP[thr]}/NP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/S[em]",
		"{S[dcl]/NP[expl]}/NP",
		"{S[ng]\\NP}\\{S[adj]\\NP}",
		"{S[b]\\NP}/{S[ng]\\NP}",
		"{S[dcl]\\NP[expl]}/{S[to]\\NP}",
		"{{S\\NP}\\{S\\NP}}/NP",
		"{S[b]\\NP}/S[em]",
		"{S[dcl]\\NP[expl]}/S[for]",
		"{N\\NP}/{S[to]\\NP}",
		"{S[dcl]\\S[dcl]}/NP",
		"S/N",
		"{S\\S}/{{S[to]\\NP}/NP}",
		"{{{S\\NP}/{S\\NP}}/S[dcl]}/N",
		"S/S",
		"{{S\\NP}\\{S\\NP}}/{S[dcl]\\NP}",
		"{S[adj]\\NP}/{S[to]\\NP}",
		"{{S[dcl]\\NP}/S[dcl]}/NP",
		"{{S[ng]\\NP}/PP}/PP",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[dcl]\\NP}",
		"{S[dcl]/{S[pt]\\NP}}/NP",
		"NP/{S[adj]\\NP}",
		"{S[pt]\\NP}/{S[b]\\NP}",
		"{{{S[b]\\NP}/PP}/NP}/{S[adj]\\NP}",
		"{S[adj]\\NP}/S[for]",
		"S[wq]/{S[ng]\\NP}",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/{S[asup]\\NP}",
		"{{{NP\\NP}/{NP\\NP}}\\{{NP\\NP}/{NP\\NP}}}/{{NP\\NP}/{NP\\NP}}",
		"{{S\\NP}\\{S\\NP}}/S[inv]",
		"{S[adj]\\NP}/{S[pss]\\NP}",
		"{{S\\NP}\\{S\\NP}}/{S[to]\\NP}",
		"{{S\\NP}\\{S\\NP}}/S[qem]",
		"{{{S[dcl]\\NP}/PP}/NP}/NP",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}",
		"{{NP\\NP}/NP}/NP",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/PP",
		"{{S\\NP}\\{S\\NP}}/S[frg]",
		"{S[dcl]\\{S[adj]\\NP}}/NP",
		"{N\\NP}/{S[b]\\NP}",
		"{PP\\PP}/S[dcl]",
		"{{{N/N}/{N/N}}\\{{N/N}/{N/N}}}/NP",
		"{N\\N}/{S[to]\\NP}",
		"{{S[dcl]\\S[dcl]}\\NP}/{S[pss]\\NP}",
		"{{{S[ng]\\NP}/PP}/NP}/{S[adj]\\NP}",
		"{NP\\NP}/N",
		"{S[q]/{S[dcl]\\NP}}/NP",
		"{NP[nb]/N}/{S[adj]\\NP}",
		"S\\NP",
		"N/{{S[to]\\NP}/NP}",
		"{{N/N}/{N/N}}\\NP",
		"PP\\PP",
		"{{S[dcl]\\NP}/S[dcl]}/PP",
		"{{S[dcl]\\NP}/{S[to]\\NP}}/PP",
		"{{{S[ng]\\NP}/PP}/NP}/NP",
		"{{S[ng]\\NP}/PP}/NP",
		"{{{S\\NP}\\{S\\NP}}/{S[b]\\NP}}/NP",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[adj]\\NP}",
		"{{{N/N}/{N/N}}/{{N/N}/{N/N}}}/{S[asup]\\NP}",
		"{{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/NP}/NP",
		"PP/{S[b]\\NP}",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[ng]\\NP}}/NP",
		"{{S[pt]\\NP}/S[qem]}/{S[adj]\\NP}",
		"{S[em]/{S[b]\\NP}}/NP",
		"{{S[qem]/S[dcl]}\\{{NP\\NP}/NP}}/N",
		"S[qem]/{S[to]\\NP}",
		"{{S[dcl]\\NP}/NP}/{S[dcl]\\NP}",
		"{S[dcl]\\NP[expl]}/{S[b]\\NP}",
		"S[wq]",
		"{S[dcl]/{S[adj]\\NP}}/NP[expl]",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/NP",
		"{{S[dcl]\\{S[adj]\\NP}}\\NP}/{S[pss]\\NP}",
		"{{{S/S}\\{S/S}}/NP}\\NP",
		"{N\\NP}/NP",
		"{{S[pt]\\NP}/PP}/NP",
		"{{S[pt]\\NP}/S[em]}/NP",
		"S[wq]/S[dcl]",
		"{{S[b]\\NP}/S[em]}/{S[adj]\\NP}",
		"{NP[nb]/N}/{S[asup]\\NP}",
		"{PP/NP}/{S[adj]\\NP}",
		"{{N/N}/{N/N}}\\{{N/N}/{N/N}}",
		"{S[dcl]/S[dcl]}/NP",
		"{{S[dcl]\\S[qem]}\\NP}/S[dcl]",
		"{NP\\NP}/{S[pt]/NP}",
		"{S[pss]\\NP}/{S[to]\\NP}",
		"S[poss]/{S[ng]\\NP}",
		"{NP\\NP}/S",
		"{{{S\\NP}/{S\\NP}}/{S[to]\\NP}}/N",
		"{S[dcl]/{S[q]/N}}/N",
		"RRB",
		"{{S[pt]\\NP}/NP}/PP",
		"S[asup]\\NP",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[dcl]/NP}",
		"S[em]/{S[dcl]\\NP}",
		"{S[ng]\\NP}/S[wq]",
		"{{PP\\PP}\\{PP\\PP}}/{S[dcl]/NP}",
		"{{{S\\NP}\\{S\\NP}}/S[em]}/PP",
		"{S[dcl]\\NP}/S[for]",
		"{{{S[b]\\NP}/PP}/NP}/NP",
		"{{S[adj]\\NP}/S[for]}/{S[adj]\\NP}",
		"{{{S[pt]\\NP}/{S[to]\\NP}}/NP}/NP[expl]",
		"{S/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}",
		"{S[pss]\\NP}\\NP",
		"{{S[dcl]\\NP}\\NP}/NP",
		"{{S[dcl]\\NP[thr]}/{S[to]\\NP}}/NP",
		"{NP\\NP}/{S[ng]\\NP}",
		"{{{NP\\NP}\\{NP\\NP}}/{S[b]\\NP}}/NP",
		"{{S[dcl]\\NP[expl]}/S[dcl]}/NP",
		"{{S\\NP}/{S\\NP}}/N",
		"{{S[dcl]\\NP}/S[to]}/NP",
		"{S[ng]\\NP}/PP",
		"{NP\\NP}/S[pt]",
		"{S/S}/S[adj]",
		"{{N/N}\\{N/N}}/PP",
		"{S[adj]\\NP}/S[dcl]",
		"{S/S}/{S/S}",
		"{{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}\\NP}/{S[adj]\\NP}",
		"PP/{S[ng]\\NP}",
		"{{S\\S}\\{S\\S}}/NP",
		"{{S[pt]\\NP}/NP}/NP",
		"{S[pss]\\NP}/{S[pss]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/PP}/{S[adj]\\NP}",
		"{S[b]\\NP}/{S[pss]\\NP}",
		"{S[qem]/{S[dcl]\\N}}/N",
		"{{S/S}\\NP}/NP",
		"{S[dcl]\\S[q]}/NP",
		"{{S[dcl]\\NP[expl]}/{NP\\NP}}/NP",
		"{{S\\NP}/{S\\NP}}/:",
		"{S[ng]\\NP}/{S[ng]\\NP}",
		"S[dcl]",
		"{{NP\\NP}/{NP\\NP}}\\{{NP\\NP}/{NP\\NP}}",
		"{{S[b]\\NP}/NP}/{S[adj]\\NP}",
		"{S/{S[to]\\N}}/N",
		"{S[dcl]\\S[qem]}/{S[to]\\NP}",
		"{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}",
		"{{S[dcl]\\NP[thr]}/PP}/NP",
		"NP/{S[dcl]/NP}",
		"{{S[ng]\\NP}/{S[b]\\NP}}/NP[expl]",
		"{S[b]\\NP}\\NP",
		"{S[pt]\\NP}/{S[pss]\\NP}",
		"{NP\\NP}\\{NP\\NP}",
		"N/S[qem]",
		"{{NP\\NP}\\NP}/{S[pt]\\NP}",
		"{{S[pt]\\NP}/{S[adj]\\NP}}/NP",
		"{{S[pt]\\NP}/PP}/{S[adj]\\NP}",
		"{S/S}/{S[asup]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[asup]\\NP}",
		"{{{S[dcl]\\NP}/PP}/NP}/{S[adj]\\NP}",
		"{NP\\NP}/{NP\\NP}",
		"{{{S\\NP}\\{S\\NP}}/{S[pss]\\NP}}/NP",
		"{{N/N}\\{N/N}}/{S[b]\\NP}",
		"{{{S[dcl]\\NP}/PP}/{S[adj]\\NP}}/NP",
		"{{NP\\NP}/{NP\\NP}}\\NP",
		"{{S[ng]\\NP}/{{S[to]\\NP}/NP}}/NP",
		"{S[dcl]\\NP[thr]}/{S[adj]\\NP}",
		"{S[b]\\NP[thr]}/{S[to]\\NP}",
		"{{S/S}/{S[b]\\NP}}/NP",
		"NP\\NP",
		"{S/S}/{S[dcl]\\NP}",
		"{{S\\NP}\\{S\\NP}}/conj",
		"{S[dcl]\\NP}/NP",
		"{{{S\\NP}\\{S\\NP}}/{S[dcl]\\NP}}/NP",
		"{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/{{NP\\NP}\\{NP\\NP}}",
		"{{PP\\PP}/S[qem]}\\NP",
		"{{NP\\NP}\\NP}/{S[adj]\\NP}",
		"{{S[pss]\\NP}/{S[to]\\NP}}/PP",
		"{{S[dcl]\\NP}\\NP}/PP",
		"{S[pss]\\NP}/{S[ng]\\NP}",
		"{S[dcl]\\NP}/S[adj]",
		"{{N/N}\\{N/N}}/NP",
		"{{{S[b]\\NP}/{S[ng]\\NP}}/NP}/NP",
		"{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}/{S[asup]\\NP}",
		"{{S[dcl]\\NP}/{S[b]\\NP}}/{S[adj]\\NP}",
		"{S[ng]\\NP}/{S[pss]\\NP}",
		"{{S\\S}/{S\\S}}/{{S\\S}/{S\\S}}",
		"{{S[pt]\\{S[dcl]\\NP}}\\NP}/PP",
		"{{{S[b]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]",
		"{S[for]/{S[to]\\NP}}/NP",
		"{{S\\NP}\\{S\\NP}}/{S[pss]\\NP}",
		"{{N/N}/{N/N}}/{S[asup]\\NP}",
		"{{S[dcl]\\NP[expl]}/S[em]}/NP",
		"{{{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}}\\{{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}}}/{{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}}",
		"{{S[ng]\\NP}/{S[pt]\\NP}}/NP",
		"{S[dcl]\\{S[adj]\\NP}}/{S[b]\\NP}",
		"{S[qem]/{S[dcl]/NP}}/{S[adj]\\NP}",
		"{{S[wq]/S[q]}\\{{NP\\NP}/NP}}/N",
		"{{{S[adj]\\NP}/{S[adj]\\NP}}/PP}/{S[adj]\\NP}",
		"{S[to]\\NP}/{S[b]\\NP}",
		"{{S[dcl]\\NP[expl]}/NP}/{S[adj]\\NP}",
		"{S\\S}\\{S\\S}",
		"{{{S[dcl]\\NP}/S[for]}/{S[adj]\\NP}}/NP[expl]",
		"{{S[adj]\\NP}/S[dcl]}/{S[adj]\\NP}",
		"{{S[dcl]\\PP}/NP}/{S[b]\\NP}",
		"{S[dcl]\\NP}/PP",
		"{{S\\NP}/{S\\NP}}\\{S[adj]\\NP}",
		"{{{S[dcl]\\NP}/S[dcl]}/PP}/NP",
		"{{S[ng]\\NP}/{S[b]\\NP}}/NP",
		"{{S[q]/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]",
		"S[dcl]/NP",
		"{{S[dcl]\\NP}/PP}/PP",
		"S[b]\\S[qem]",
		"{{S[ng]\\NP}/NP}/NP",
		"{{S/S}/{S/S}}\\{{S/S}/{S/S}}",
		"{{S[adj]\\NP}/{S[adj]\\NP}}/{S[adj]\\NP}",
		"{{S[pt]\\NP}/{S[ng]\\NP}}/{S[adj]\\NP}",
		"{N/N}\\{N/N}",
		"{{S[adj]\\NP}/{S[to]\\NP}}/PP",
		"S[intj]\\NP",
		"{S[dcl]\\S[b]}/NP",
		"{S[pss]\\NP}/S[to]",
		"NP/{S[b]/NP}",
		"{{S[pss]\\NP}/PP}/{S[adj]\\NP}",
		"{S\\NP}/{S[b]\\NP}",
		"{{S\\NP}\\{S\\NP}}/{{S[b]\\NP}/NP}",
		"S/S[dcl]",
		"N/S[dcl]",
		"{{{S\\NP}\\{S\\NP}}/{S[adj]\\NP}}/NP",
		"{{N/N}\\{N/N}}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/N",
		"{S[dcl]\\PP}/S[em]",
		"{S[dcl]\\NP[expl]}/{S[pt]\\NP}",
		"{{S[adj]\\NP}\\{S[adj]\\NP}}/N[num]",
		"{NP/NP}/{S[asup]\\NP}",
		"{{S[dcl]\\NP[expl]}/S[em]}/PP",
		"{NP/{S[to]\\N}}/N",
		"{{S/S}/{S/S}}/N",
		"{{NP\\NP}/S[dcl]}\\{{NP\\NP}/NP}",
		"{S[pss]\\NP}/{S[adj]\\NP}",
		"{S\\NP}/S[dcl]",
		"{{S[dcl]\\{S[b]\\NP}}\\NP}/S[dcl]",
		"{{{S\\NP}\\{S\\NP}}/{S[q]/NP}}/N",
		"{{N/N}/{N/N}}\\{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}}/{S[adj]\\NP}",
		"{S[dcl]\\{S[pt]\\NP}}/NP",
		"{{S[qem]/S[dcl]}/N}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/N[num]",
		"{{S[b]\\NP}\\NP}/S[dcl]",
		"{N/N}\\{S[adj]\\NP}",
		"{S[b]\\NP[thr]}/NP",
		"{N/NP}/{S[to]\\NP}",
		"S[qem]/{S[adj]\\NP}",
		"{{S[dcl]\\NP}/NP}/{S[ng]\\NP}",
		"{{S[adj]\\NP}/{S[adj]\\NP}}/N[num]",
		"{{S\\NP}/{S\\NP}}/{S[asup]\\NP}",
		"{S[b]\\NP}/{S[pt]\\NP}",
		"{S[dcl]\\NP}/S[bem]",
		"{{S[dcl]\\NP}/PP}/NP",
		"{{S[dcl]\\NP[expl]}/S[for]}/NP",
		"{S\\S}/N[num]",
		"{S[dcl]\\NP[expl]}/S[em]",
		"S[qem]/{{S[to]\\NP}/NP}",
		"{{S[b]\\NP}/S[qem]}/{S[adj]\\NP}",
		"{{S[pt]\\NP}/{S[ng]\\NP}}/NP",
		"{{S[b]\\NP}/S[qem]}/NP",
		"{N/N}/{{S[to]\\NP}/NP}",
		"{{S[dcl]\\NP}/S[em]}/NP",
		"conj",
		"{S/PP}/NP",
		"N/NP",
		"{S[dcl]\\NP[expl]}/S[dcl]",
		"{{S\\NP}\\{S\\NP}}/S[q]",
		"{{S[pss]\\NP}/{S[adj]\\NP}}/PP",
		"{{{NP\\NP}\\{NP\\NP}}/{S[dcl]\\N}}/N",
		"{{S[dcl]\\NP}/{S[ng]\\NP}}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/NP",
		"{{S\\S}\\{S\\S}}/S[dcl]",
		"{{S[dcl]\\NP[expl]}/S[em]}/S[qem]",
		"{PP\\NP}/NP",
		"S[to]\\NP",
		"{{S\\S}/{S[pt]\\NP}}/NP",
		"{{S\\NP}\\{S\\NP}}/{S[dcl]/NP}",
		"{S[wq]/{S[to]\\NP}}/{S[adj]\\NP}",
		"{S[em]/{S[pss]\\NP}}/NP",
		"{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[dcl]\\NP}",
		"{{S[ng]\\NP}/S[em]}/NP",
		"{S\\S}/S[q]",
		"{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}",
		"PP/S[qem]",
		"{S[ng]\\NP}/{S[pt]\\NP}",
		"{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}/{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}",
		"{{S[b]\\NP}/NP}/NP",
		"{PP\\PP}\\{PP\\PP}",
		"{S[pss]\\NP}/S[em]",
		"{{S[b]\\NP}/{S[b]\\NP}}/PP",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}\\{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}",
		"S[q]/PP",
		"S[pss]",
		"{{{S\\NP}\\{S\\NP}}\\NP}/S[dcl]",
		"{NP\\NP}/S[ng]",
		"{N/S[qem]}\\NP",
		"{{S[adj]\\NP}/NP}/PP",
		"{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{S[dcl]\\NP}",
		"{S[dcl]\\NP}/{S[em]\\NP}",
		"{S[dcl]\\{S[to]\\NP}}/{S[adj]\\NP}",
		"{{{S\\NP}\\{S\\NP}}/NP}/{S[adj]\\NP}",
		"S[frg]/{S[adj]\\NP}",
		"{{S[dcl]\\NP}/S}/NP",
		"{{S[pt]\\NP}/{S[to]\\NP}}/PP",
		"{{S/S}\\NP}\\NP",
		"{S[dcl]\\NP[expl]}/{S[adj]\\NP}",
		"{S[frg]/NP}/NP",
		"{S[qem]/{S[dcl]/N}}/N",
		"{{S[ng]\\NP}/S}/PP",
		"N/PP",
		"{{S[dcl]\\NP[expl]}/S[for]}/{S[adj]\\NP}",
		"{{S[dcl]\\S[dcl]}\\NP}/{S[ng]\\NP}",
		"{S[b]\\NP}/{S[b]\\NP}",
		"{{NP\\NP}/{NP\\NP}}/NP",
		"{{PP/PP}\\{PP/PP}}/NP",
		"{{S[adj]\\NP}/NP}/{S[adj]\\NP}",
		"{S[dcl]\\{S[ng]\\NP}}/{S[b]\\NP}",
		"{N\\N}/N[num]",
		"{{NP\\NP}\\{NP\\NP}}/{NP\\NP}",
		"{PP\\NP}/PP",
		"S[wq]/S[poss]",
		"{{S[dcl]\\NP}/PP}/{S[adj]\\NP}",
		"PP/S[dcl]",
		"{{{S\\NP}\\{S\\NP}}/{S[ng]\\NP}}/NP",
		"{S[q]/S[qem]}/NP",
		"{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[pss]\\NP}",
		"{S[adj]\\NP}\\NP",
		"{S[pss]\\NP}/S",
		"{{S[dcl]\\NP}/S[for]}/{S[adj]\\NP}",
		"{NP\\NP}/{S[adj]\\NP}",
		"{{S\\NP}/{S\\NP}}/{S[ng]\\NP}",
		"{S[dcl]/{S[ng]\\NP}}/NP",
		"{{S[pt]\\NP}/{S[to]\\NP}}/NP",
		"{{S[ng]\\NP}/{S[b]\\NP}}/PP",
		"S[q]/NP",
		"{{S[b]\\NP}/{S[b]\\NP}}/NP",
		"S[poss]/S[dcl]",
		"{N/N}/{N/N}",
		"{{S[for]\\NP[expl]}/{S[to]\\NP}}/NP",
		"S[bem]/S[b]",
		"S[poss]/{S[pss]\\NP}",
		"{{S\\NP}\\{S\\NP}}/{S[asup]\\NP}",
		"{{S[dcl]\\NP}/S[poss]}/NP",
		"{{S[dcl]\\{S[b]\\NP}}\\NP}/{S[to]\\NP}",
		"LRB",
		"{S[dcl]\\NP}\\NP",
		"{S[pss]\\NP}/PP",
		"{{S[adj]\\NP}/PP}/{S[adj]\\NP}",
		"{{S[ng]\\NP}/S[qem]}/NP",
		"{{S/S}\\{S/S}}\\NP",
		"{S[dcl]/NP}/NP",
		"{{{{NP\\NP}\\{NP\\NP}}/S[dcl]}\\{{NP\\NP}/NP}}/N",
		"{S/S}/S[poss]",
		"{{S[dcl]\\NP[expl]}/S[em]}/{S[adj]\\NP}",
		"{S/S}/S[dcl]",
		"{S[dcl]\\S[b]}\\NP",
		"{S[pss]\\NP}/{S[b]\\NP}",
		"{{S[pt]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}",
		"{{S/S}/S[dcl]}/N",
		"{{NP\\NP}/{S[ng]\\NP}}/NP",
		"{{S[dcl]/S[dcl]}\\NP}/NP",
		"{S[wq]/{S[q]/N}}/N",
		"N/{S[to]\\NP}",
		"{{NP\\NP}/{S[dcl]\\NP}}\\{{NP\\NP}/NP}",
		"{NP\\NP}/{S[b]\\NP}",
		"{{S[b]\\NP}/S[bem]}/PP",
		"{{NP\\NP}/{S[dcl]/PP}}\\{{NP\\NP}/NP}",
		"{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}/{S[asup]\\NP}",
		"{{{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}}\\NP}/{S[ng]\\NP}",
		"{{{S[dcl]\\NP}/{S[to]\\NP}}/NP}/NP",
		"{NP\\NP}\\{{NP\\NP}/NP}",
		"{{S\\NP}\\{S\\NP}}/S[ng]",
		"S[dcl]\\NP",
		"{{S[pss]\\NP}/{S[to]\\NP}}/NP",
		"{S[adj]\\NP}/S[qem]",
		"{PP\\PP}/{S[dcl]\\NP}",
		"{{S[dcl]\\{S[dcl]\\NP}}/NP}/S[dcl]",
		"{{S[pt]\\NP}/{S[pss]\\NP}}/NP",
		"{S[pss]\\NP}/NP",
		"{S[frg]/NP}/PP",
		"S[frg]/S[em]",
		"{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/NP",
		"{S[dcl]\\NP[thr]}/{S[pss]\\NP}",
		"{{S[dcl]\\NP[expl]}/S[em]}/{S[to]\\NP}",
		"{{S[dcl]\\NP}\\NP}/{S[ng]\\NP}",
		"{S[pt]\\NP}/{S[to]\\NP}",
		"{{S[ng]\\NP}/S[qem]}/PP",
		"{{S[dcl]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}",
		"{{S[dcl]\\NP}\\NP}/S[em]",
		"{{S[dcl]\\NP}/S[em]}/PP",
		"{{S[pss]\\NP}/{S[adj]\\NP}}/NP",
		"{{S[dcl]\\{S[adj]\\NP}}\\NP}/S[dcl]",
		"S[qem]",
		"{{S[to]\\NP}/{S[b]\\NP}}/{S[b]\\NP}",
		"{{S[dcl]\\NP[expl]}/S[qem]}/NP",
		"{N\\N}/N",
		"PP/N",
		"{{NP\\NP}/{NP\\NP}}/S[dcl]",
		"{{S[ng]\\NP}/S[em]}/PP",
		"{S[q]/{S[b]\\NP}}/NP[expl]",
		"S[frg]",
		"{{{{NP\\NP}/NP}/NP}/NP}/NP",
		"{S[dcl]\\{S[adj]\\NP}}/S[dcl]",
		"{N/PP}/{S[adj]\\NP}",
		"{S[ng]\\NP}/NP",
		"{{S[b]\\NP}/NP}/PP",
		"{S[pt]\\NP}/{S[adj]\\NP}",
		"S[frg]/{S[to]\\NP}",
		"{NP/NP}/{NP/NP}",
		"N/S[bem]",
		"{{N\\N}/S[dcl]}\\{{NP\\NP}/NP}",
		"{{NP\\NP}\\NP}/{S[b]\\NP}",
		"{{S[dcl]\\NP[expl]}/S[dcl]}/PP",
		"{{{{S\\NP}\\{S\\NP}}/N}\\{{{S\\NP}\\{S\\NP}}/N}}/{{{S\\NP}\\{S\\NP}}/N}",
		"{{S[ng]\\NP}/S}/NP",
		"{{S[dcl]\\NP}/S}/{S[adj]\\NP}"
	};
	
	public static final Map<String, Integer> PENN_DEP_MAP = new HashMap<String, Integer>();
	static {
		PENN_DEP_MAP.put("-NONE-", new Integer(0));
		PENN_DEP_MAP.put("{S[pt]\\NP}/S[bem]", new Integer(1));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[dcl]}/{S[adj]\\NP}", new Integer(2));
		PENN_DEP_MAP.put("{PP/NP}/N[num]", new Integer(3));
		PENN_DEP_MAP.put("{S[dcl]\\NP[thr]}/{S[pt]\\NP}", new Integer(4));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[ng]\\NP}}/PP}/NP", new Integer(5));
		PENN_DEP_MAP.put("S/{S[pss]\\NP}", new Integer(6));
		PENN_DEP_MAP.put("{{NP\\NP}/S[qem]}\\NP", new Integer(7));
		PENN_DEP_MAP.put("S[wq]/S[b]", new Integer(8));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}\\{S[adj]\\NP}", new Integer(9));
		PENN_DEP_MAP.put("{S[ng]\\NP}/{S[b]\\NP}", new Integer(10));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}", new Integer(11));
		PENN_DEP_MAP.put("{NP/NP}/N[num]", new Integer(12));
		PENN_DEP_MAP.put("{NP\\NP}/S[intj]", new Integer(13));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/N[num]", new Integer(14));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}\\NP", new Integer(15));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[to]\\NP}}/NP", new Integer(16));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[qem]", new Integer(17));
		PENN_DEP_MAP.put("{{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}\\{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}}/{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}", new Integer(18));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[q]", new Integer(19));
		PENN_DEP_MAP.put("{S\\S}/S[wq]", new Integer(20));
		PENN_DEP_MAP.put("{NP/{{S[to]\\NP}/NP}}/N", new Integer(21));
		PENN_DEP_MAP.put("{NP\\NP}/S[em]", new Integer(22));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/{S[ng]\\NP}", new Integer(23));
		PENN_DEP_MAP.put("{S[q]/{S[adj]\\NP}}/NP", new Integer(24));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}/N", new Integer(25));
		PENN_DEP_MAP.put("PP/S", new Integer(26));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/S[em]}/PP}/NP[expl]", new Integer(27));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/{S[ng]\\NP}", new Integer(28));
		PENN_DEP_MAP.put("S[qem]/{S[b]\\NP}", new Integer(29));
		PENN_DEP_MAP.put(",", new Integer(30));
		PENN_DEP_MAP.put("S[adj]", new Integer(31));
		PENN_DEP_MAP.put(".", new Integer(32));
		PENN_DEP_MAP.put("{PP\\PP}\\NP", new Integer(33));
		PENN_DEP_MAP.put("{{S[qem]/{S[to]\\NP}}\\{{NP\\NP}/NP}}/N", new Integer(34));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[adj]\\NP}", new Integer(35));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/PP}/PP}/NP", new Integer(36));
		PENN_DEP_MAP.put("{{S/S}\\{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(37));
		PENN_DEP_MAP.put("{{S[b]\\NP}\\NP}/{S[adj]\\NP}", new Integer(38));
		PENN_DEP_MAP.put("{S[dcl]\\S}/{S[b]\\NP}", new Integer(39));
		PENN_DEP_MAP.put("{PP/{S[pss]\\NP}}/NP", new Integer(40));
		PENN_DEP_MAP.put(":", new Integer(41));
		PENN_DEP_MAP.put("{S[dcl]/{S[b]\\NP}}/NP", new Integer(42));
		PENN_DEP_MAP.put(";", new Integer(43));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/N[num]", new Integer(44));
		PENN_DEP_MAP.put("N\\N", new Integer(45));
		PENN_DEP_MAP.put("{{S/S}\\NP}/{S[ng]\\NP}", new Integer(46));
		PENN_DEP_MAP.put("S[pss]/{S[to]\\NP}", new Integer(47));
		PENN_DEP_MAP.put("{S[q]/{S[to]\\NP}}/NP", new Integer(48));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[pss]", new Integer(49));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[poss]", new Integer(50));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[em]", new Integer(51));
		PENN_DEP_MAP.put("{S/S}/N[num]", new Integer(52));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[dcl]\\N}}/N", new Integer(53));
		PENN_DEP_MAP.put("N/S[for]", new Integer(54));
		PENN_DEP_MAP.put("{NP\\NP}/N[num]", new Integer(55));
		PENN_DEP_MAP.put("N", new Integer(56));
		PENN_DEP_MAP.put("{S[dcl]/S[ng]}/NP", new Integer(57));
		PENN_DEP_MAP.put("{S[pss]\\NP}/S[dcl]", new Integer(58));
		PENN_DEP_MAP.put("S", new Integer(59));
		PENN_DEP_MAP.put("{{S/S}/S[dcl]}/{S[asup]\\NP}", new Integer(60));
		PENN_DEP_MAP.put("S[frg]/S[qem]", new Integer(61));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]", new Integer(62));
		PENN_DEP_MAP.put("{{S/S}/{S[to]\\NP}}/NP[thr]", new Integer(63));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/PP}/{S[adj]\\NP}}/NP", new Integer(64));
		PENN_DEP_MAP.put("{{{N/N}/{N/N}}\\{{N/N}/{N/N}}}/{{N/N}/{N/N}}", new Integer(65));
		PENN_DEP_MAP.put("{S\\S}/NP", new Integer(66));
		PENN_DEP_MAP.put("{S[pt]\\NP}/S[em]", new Integer(67));
		PENN_DEP_MAP.put("{{{S\\S}\\{S\\S}}\\{{S\\S}\\{S\\S}}}/S[dcl]", new Integer(68));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/NP}/NP", new Integer(69));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[q]}/NP", new Integer(70));
		PENN_DEP_MAP.put("S[em]/PP", new Integer(71));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/PP}/S[intj]", new Integer(72));
		PENN_DEP_MAP.put("S[dcl]/{S[pt]\\NP}", new Integer(73));
		PENN_DEP_MAP.put("{{S/S}\\NP}/S[dcl]", new Integer(74));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[ng]\\NP}}/{S[adj]\\NP}", new Integer(75));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[b]\\NP}}/NP", new Integer(76));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[dcl]}/{S[adj]\\NP}", new Integer(77));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[b]}/NP", new Integer(78));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[b]", new Integer(79));
		PENN_DEP_MAP.put("N/{S[adj]\\NP}", new Integer(80));
		PENN_DEP_MAP.put("{NP/NP}/{S[adj]\\NP}", new Integer(81));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[thr]}/{S[pss]\\NP}}/NP", new Integer(82));
		PENN_DEP_MAP.put("{{S[b]\\NP}\\NP}/{S[b]\\NP}", new Integer(83));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[b]\\NP}", new Integer(84));
		PENN_DEP_MAP.put("{S[adj]\\NP}/NP", new Integer(85));
		PENN_DEP_MAP.put("{S/S}/N", new Integer(86));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\S[dcl]}/NP", new Integer(87));
		PENN_DEP_MAP.put("S[wq]/{S[dcl]/NP}", new Integer(88));
		PENN_DEP_MAP.put("{S[to]\\NP}/NP", new Integer(89));
		PENN_DEP_MAP.put("{{S/S}/{S[adj]\\NP}}/NP", new Integer(90));
		PENN_DEP_MAP.put("{S[adj]\\NP}/S[poss]", new Integer(91));
		PENN_DEP_MAP.put("{{S[b]\\NP}/NP}/{S[to]\\NP}", new Integer(92));
		PENN_DEP_MAP.put("{S[q]/{S[pt]\\NP}}/NP", new Integer(93));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[ng]\\NP}", new Integer(94));
		PENN_DEP_MAP.put("{{{N/N}\\{N/N}}\\{{N/N}\\{N/N}}}/N", new Integer(95));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}/N[num]", new Integer(96));
		PENN_DEP_MAP.put("{S[pt]\\NP}/S[adj]", new Integer(97));
		PENN_DEP_MAP.put("{S[q]/{S[pss]\\NP}}/NP", new Integer(98));
		PENN_DEP_MAP.put("S/{S[adj]\\NP}", new Integer(99));
		PENN_DEP_MAP.put("{{S[dcl]\\S[q]}\\NP}/S[dcl]", new Integer(100));
		PENN_DEP_MAP.put("{{{S[dcl]\\S[dcl]}\\NP}/S[q]}/PP", new Integer(101));
		PENN_DEP_MAP.put("{S[pt]/S[dcl]}/NP", new Integer(102));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}/S[dcl]}/NP", new Integer(103));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[b]\\NP}", new Integer(104));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/S[em]}/PP", new Integer(105));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/NP}/PP", new Integer(106));
		PENN_DEP_MAP.put("{S[dcl]\\S[wq]}\\NP", new Integer(107));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}/{{S/S}\\{S/S}}", new Integer(108));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}", new Integer(109));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}", new Integer(110));
		PENN_DEP_MAP.put("{S[b]/{S[pt]\\NP}}/NP", new Integer(111));
		PENN_DEP_MAP.put("{S[pt]\\NP}/S[for]", new Integer(112));
		PENN_DEP_MAP.put("{{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}\\{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}}/N", new Integer(113));
		PENN_DEP_MAP.put("{NP\\NP}/S[q]", new Integer(114));
		PENN_DEP_MAP.put("{S[dcl]\\NP}\\{S[adj]\\NP}", new Integer(115));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[to]\\NP}}/PP}/NP[expl]", new Integer(116));
		PENN_DEP_MAP.put("{PP/PP}/{S[asup]\\NP}", new Integer(117));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S}/PP", new Integer(118));
		PENN_DEP_MAP.put("{S[adj]\\NP}/PP", new Integer(119));
		PENN_DEP_MAP.put("{{S[b]\\NP}\\NP}/PP", new Integer(120));
		PENN_DEP_MAP.put("{N/N}/S[dcl]", new Integer(121));
		PENN_DEP_MAP.put("{N\\N}/{S[dcl]\\NP}", new Integer(122));
		PENN_DEP_MAP.put("{{NP\\NP}/S[pt]}\\{{NP\\NP}/NP}", new Integer(123));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[to]\\NP}}/NP", new Integer(124));
		PENN_DEP_MAP.put("{S[pss]\\NP}/S[qem]", new Integer(125));
		PENN_DEP_MAP.put("{S[dcl]\\PP}/NP", new Integer(126));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/{S[to]\\NP}}/{PP/NP}", new Integer(127));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[to]", new Integer(128));
		PENN_DEP_MAP.put("S[dcl]/S[dcl]", new Integer(129));
		PENN_DEP_MAP.put("S[frg]/S", new Integer(130));
		PENN_DEP_MAP.put("S[frg]/N", new Integer(131));
		PENN_DEP_MAP.put("{{S\\S}/{S[to]\\N}}/N", new Integer(132));
		PENN_DEP_MAP.put("{{NP\\NP}/PP}/{{NP\\NP}/PP}", new Integer(133));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/NP}/{S[adj]\\NP}}/NP", new Integer(134));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[to]\\NP}}/PP", new Integer(135));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[em]", new Integer(136));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[for]", new Integer(137));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/{S[ng]\\NP}}/NP", new Integer(138));
		PENN_DEP_MAP.put("{{S\\S}/{S\\S}}/{S[adj]\\NP}", new Integer(139));
		PENN_DEP_MAP.put("{N/N}/{S[adj]\\NP}", new Integer(140));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[b]\\NP}", new Integer(141));
		PENN_DEP_MAP.put("{NP\\NP}/{S[asup]\\NP}", new Integer(142));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/PP}/PP}/NP", new Integer(143));
		PENN_DEP_MAP.put("S[b]\\NP", new Integer(144));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}/{{N/N}/{N/N}}", new Integer(145));
		PENN_DEP_MAP.put("S[to]/{S[b]\\NP}", new Integer(146));
		PENN_DEP_MAP.put("NP/{{S[to]\\NP}/NP}", new Integer(147));
		PENN_DEP_MAP.put("{{{S[dcl]\\S[dcl]}\\NP}/PP}/NP", new Integer(148));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/S[dcl]", new Integer(149));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/{S[ng]\\NP}}/NP", new Integer(150));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{S\\NP}\\{S\\NP}}", new Integer(151));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[em]}/{S[to]\\NP}", new Integer(152));
		PENN_DEP_MAP.put("S[qem]/{S[dcl]/NP}", new Integer(153));
		PENN_DEP_MAP.put("{PP\\PP}/PP", new Integer(154));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}/S[dcl]", new Integer(155));
		PENN_DEP_MAP.put("{{NP/NP}/S[dcl]}/{S[adj]\\NP}", new Integer(156));
		PENN_DEP_MAP.put("{S/S}/NP", new Integer(157));
		PENN_DEP_MAP.put("{N\\N}/{S[adj]\\NP}", new Integer(158));
		PENN_DEP_MAP.put("{{S[dcl]\\S[qem]}\\NP}/{S[b]\\NP}", new Integer(159));
		PENN_DEP_MAP.put("{{S[b]\\NP}/PP}/{S[adj]\\NP}", new Integer(160));
		PENN_DEP_MAP.put("{{S\\{S\\NP}}\\{S\\{S\\NP}}}/NP", new Integer(161));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}/NP", new Integer(162));
		PENN_DEP_MAP.put("{S[dcl]/NP}/{S[pss]\\NP}", new Integer(163));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}", new Integer(164));
		PENN_DEP_MAP.put("{{S/S}/{S[pss]\\NP}}/NP", new Integer(165));
		PENN_DEP_MAP.put("{{S[qem]/{S[dcl]/NP}}/N}/{S[adj]\\NP}", new Integer(166));
		PENN_DEP_MAP.put("{S[b]\\NP}/{PP/NP}", new Integer(167));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(168));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[b]\\NP}}\\NP}/NP", new Integer(169));
		PENN_DEP_MAP.put("{S[dcl]\\{S[adj]\\NP}}/{S[to]\\NP}", new Integer(170));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}/{S[adj]\\NP}", new Integer(171));
		PENN_DEP_MAP.put("{PP/PP}/NP", new Integer(172));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[adj]\\NP}}/PP", new Integer(173));
		PENN_DEP_MAP.put("{S[qem]/{S[pt]\\NP}}/NP", new Integer(174));
		PENN_DEP_MAP.put("{S[pt]\\NP}/S", new Integer(175));
		PENN_DEP_MAP.put("{S[pt]\\NP}/S[dcl]", new Integer(176));
		PENN_DEP_MAP.put("{N/N}/S[frg]", new Integer(177));
		PENN_DEP_MAP.put("{{NP/NP}/{NP/NP}}/{S[adj]\\NP}", new Integer(178));
		PENN_DEP_MAP.put("S[wq]/{S[q]/NP}", new Integer(179));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S}/{S[to]\\NP}", new Integer(180));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[qem]}/NP", new Integer(181));
		PENN_DEP_MAP.put("{S[pt]\\S[dcl]}/NP", new Integer(182));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/PP", new Integer(183));
		PENN_DEP_MAP.put("{N/N}/S[qem]", new Integer(184));
		PENN_DEP_MAP.put("{S/{S[to]\\NP}}/NP", new Integer(185));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[to]\\NP}}/{S[to]\\NP}", new Integer(186));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}/{S[adj]\\NP}", new Integer(187));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/{S[pss]\\NP}", new Integer(188));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/S[dcl]}/N", new Integer(189));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[q]}/NP", new Integer(190));
		PENN_DEP_MAP.put("{S[b]\\NP}/NP", new Integer(191));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[to]\\NP}}/NP", new Integer(192));
		PENN_DEP_MAP.put("{{S[q]/S[dcl]}/{S[b]\\NP}}/NP", new Integer(193));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}/N", new Integer(194));
		PENN_DEP_MAP.put("{PP/{S[ng]\\NP}}/NP", new Integer(195));
		PENN_DEP_MAP.put("{S\\S}/N", new Integer(196));
		PENN_DEP_MAP.put("{{NP\\NP}/{{S[to]\\NP}/NP}}/NP", new Integer(197));
		PENN_DEP_MAP.put("{S[dcl]\\NP[thr]}/{S[to]\\NP}", new Integer(198));
		PENN_DEP_MAP.put("{S/S}/{S[to]\\NP}", new Integer(199));
		PENN_DEP_MAP.put("{N\\N}/{S[ng]\\NP}", new Integer(200));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[pss]\\NP}", new Integer(201));
		PENN_DEP_MAP.put("{PP\\PP}/N[num]", new Integer(202));
		PENN_DEP_MAP.put("S[poss]/{S[to]\\NP}", new Integer(203));
		PENN_DEP_MAP.put("{{S[b]\\NP}\\NP}/NP", new Integer(204));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[adj]\\NP}}\\NP[expl]}/{S[to]\\NP}", new Integer(205));
		PENN_DEP_MAP.put("N/{S[dcl]/NP}", new Integer(206));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[ng]\\NP}", new Integer(207));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[qem]}/PP", new Integer(208));
		PENN_DEP_MAP.put("{N/N}/{S[asup]\\NP}", new Integer(209));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[bem]", new Integer(210));
		PENN_DEP_MAP.put("{S[wq]/NP}/NP", new Integer(211));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/NP", new Integer(212));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[pss]\\NP}}/NP", new Integer(213));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/NP}/PP", new Integer(214));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[wq]", new Integer(215));
		PENN_DEP_MAP.put("{S/S}\\{S/S}", new Integer(216));
		PENN_DEP_MAP.put("{{NP/NP}/{NP/NP}}/{S[asup]\\NP}", new Integer(217));
		PENN_DEP_MAP.put("{S[b]\\NP}/PP", new Integer(218));
		PENN_DEP_MAP.put("{S[wq]/S[q]}\\{{NP\\NP}/NP}", new Integer(219));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/PP", new Integer(220));
		PENN_DEP_MAP.put("{S/{S[pt]\\NP}}/NP", new Integer(221));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[qem]}/{S[adj]\\NP}", new Integer(222));
		PENN_DEP_MAP.put("{NP\\NP}/{S[q]/NP}", new Integer(223));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/S[em]", new Integer(224));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}/{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}", new Integer(225));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/N", new Integer(226));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[em]}/{S[adj]\\NP}", new Integer(227));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/{S[to]\\NP}", new Integer(228));
		PENN_DEP_MAP.put("{S[q]/S[em]}/NP", new Integer(229));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}\\{S[adj]\\NP}", new Integer(230));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}\\NP", new Integer(231));
		PENN_DEP_MAP.put("S/{S[ng]\\NP}", new Integer(232));
		PENN_DEP_MAP.put("{S[dcl]\\S[em]}/NP", new Integer(233));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}", new Integer(234));
		PENN_DEP_MAP.put("{S[dcl]\\S[pss]}/NP", new Integer(235));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[dcl]\\NP}}/NP}/NP", new Integer(236));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[bem]}/{S[adj]\\NP}", new Integer(237));
		PENN_DEP_MAP.put("{S[dcl]\\NP[thr]}/{S[ng]\\NP}", new Integer(238));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/PP}/{S[ng]\\NP}", new Integer(239));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[dcl]", new Integer(240));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/NP}/S[dcl]", new Integer(241));
		PENN_DEP_MAP.put("{{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}}/{{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}}", new Integer(242));
		PENN_DEP_MAP.put("{{S/S}/{S/S}}/{{S/S}/{S/S}}", new Integer(243));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}\\{S[adj]\\NP}}/PP}/NP", new Integer(244));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[pss]\\NP}", new Integer(245));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S", new Integer(246));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/{S[pt]\\NP}", new Integer(247));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/S[dcl]}/{S[adj]\\NP}}/NP[expl]", new Integer(248));
		PENN_DEP_MAP.put("{S\\S}/{S[asup]\\NP}", new Integer(249));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}\\{S[adj]\\NP}}/S[em]}/NP", new Integer(250));
		PENN_DEP_MAP.put("{S[dcl]\\S[wq]}/NP", new Integer(251));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[dcl]\\NP}}\\{NP/NP}", new Integer(252));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/PP}/NP", new Integer(253));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{S[asup]\\NP}", new Integer(254));
		PENN_DEP_MAP.put("{S[q]/{S[pt]\\NP}}/NP[expl]", new Integer(255));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/NP}/{S[adj]\\NP}}/NP", new Integer(256));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/{S[to]\\NP}}/PP}/NP", new Integer(257));
		PENN_DEP_MAP.put("{{NP/NP}/{NP/NP}}\\{S[adj]\\NP}", new Integer(258));
		PENN_DEP_MAP.put("{N/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}", new Integer(259));
		PENN_DEP_MAP.put("NP[nb]/N", new Integer(260));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[adj]\\NP}}\\NP}/NP", new Integer(261));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/S[qem]}\\NP", new Integer(262));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[q]", new Integer(263));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[ng]\\NP}}/NP", new Integer(264));
		PENN_DEP_MAP.put("NP", new Integer(265));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/PP}/PP}/NP", new Integer(266));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/NP", new Integer(267));
		PENN_DEP_MAP.put("{S[dcl]/NP}/NP[thr]", new Integer(268));
		PENN_DEP_MAP.put("{{{NP\\NP}/S[dcl]}\\{{NP\\NP}/NP}}/N", new Integer(269));
		PENN_DEP_MAP.put("{S[inv]/{S[ng]\\NP}}/NP", new Integer(270));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/{S[adj]\\NP}", new Integer(271));
		PENN_DEP_MAP.put("{{NP/NP}\\{NP/NP}}/N", new Integer(272));
		PENN_DEP_MAP.put("{S[dcl]\\NP[thr]}/NP", new Integer(273));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S", new Integer(274));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[dcl]/NP}}\\{NP/NP}", new Integer(275));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/S[dcl]", new Integer(276));
		PENN_DEP_MAP.put("S[b]/NP", new Integer(277));
		PENN_DEP_MAP.put("{NP\\NP}/{S[pss]\\NP}", new Integer(278));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[b]", new Integer(279));
		PENN_DEP_MAP.put("{S\\NP}/N", new Integer(280));
		PENN_DEP_MAP.put("{{{S[dcl]/S[dcl]}\\NP}/S[em]}/NP", new Integer(281));
		PENN_DEP_MAP.put("{NP\\NP}/{S[dcl]\\NP}", new Integer(282));
		PENN_DEP_MAP.put("NP/S[dcl]", new Integer(283));
		PENN_DEP_MAP.put("{PP/PP}/PP", new Integer(284));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{{S[to]\\NP}/NP}}/{S[adj]\\NP}", new Integer(285));
		PENN_DEP_MAP.put("{{S[qem]/S[dcl]}/{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(286));
		PENN_DEP_MAP.put("{{{NP\\NP}/{S[dcl]\\NP}}\\{NP/NP}}/N", new Integer(287));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[adj]\\NP}}/NP", new Integer(288));
		PENN_DEP_MAP.put("{{NP[nb]/N}/PP}/{S[adj]\\NP}", new Integer(289));
		PENN_DEP_MAP.put("{S\\S}/{S\\S}", new Integer(290));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/N", new Integer(291));
		PENN_DEP_MAP.put("{S[dcl]\\S[em]}/PP", new Integer(292));
		PENN_DEP_MAP.put("{{NP/NP}/{NP/NP}}/{{NP/NP}/{NP/NP}}", new Integer(293));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[pss]\\NP}}/NP", new Integer(294));
		PENN_DEP_MAP.put("{{S[b]\\NP}/PP}/S[intj]", new Integer(295));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[dcl]\\NP}", new Integer(296));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP[expl]}/{NP\\NP}}/NP}/{S[adj]\\NP}", new Integer(297));
		PENN_DEP_MAP.put("{S[pss]\\NP}/{PP/NP}", new Integer(298));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S", new Integer(299));
		PENN_DEP_MAP.put("{S[inv]/{S[adj]\\NP}}/NP", new Integer(300));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/S[em]}/NP}/NP", new Integer(301));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/PP}/PP", new Integer(302));
		PENN_DEP_MAP.put("{S[to]\\NP}/{S[ng]\\NP}", new Integer(303));
		PENN_DEP_MAP.put("{S[q]/{S[b]\\NP}}/NP", new Integer(304));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}", new Integer(305));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[pt]", new Integer(306));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[pt]\\NP}}/NP", new Integer(307));
		PENN_DEP_MAP.put("S[em]", new Integer(308));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\PP}/{{{S\\NP}\\{S\\NP}}\\PP}", new Integer(309));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]", new Integer(310));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}", new Integer(311));
		PENN_DEP_MAP.put("{S[b]\\NP}/{S[to]\\NP}", new Integer(312));
		PENN_DEP_MAP.put("{S\\S}/{S[b]\\NP}", new Integer(313));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/S[em]}/{S[adj]\\NP}", new Integer(314));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/PP}/{S[adj]\\NP}", new Integer(315));
		PENN_DEP_MAP.put("{S[b]\\NP}/{S[dcl]\\NP}", new Integer(316));
		PENN_DEP_MAP.put("{{S\\S}\\{S\\S}}/{{S\\S}\\{S\\S}}", new Integer(317));
		PENN_DEP_MAP.put("PP", new Integer(318));
		PENN_DEP_MAP.put("conj/conj", new Integer(319));
		PENN_DEP_MAP.put("{S[dcl]\\S[em]}/{S[b]\\NP}", new Integer(320));
		PENN_DEP_MAP.put("S/{S[dcl]\\NP}", new Integer(321));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/NP}/{S[adj]\\NP}", new Integer(322));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}", new Integer(323));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[poss]", new Integer(324));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}\\{{NP\\NP}/NP}", new Integer(325));
		PENN_DEP_MAP.put("{{S[dcl]\\PP}/NP}/{S[ng]\\NP}", new Integer(326));
		PENN_DEP_MAP.put("{S/S}/S[ng]", new Integer(327));
		PENN_DEP_MAP.put("N/{S[dcl]\\NP}", new Integer(328));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[as]", new Integer(329));
		PENN_DEP_MAP.put("N/S[b]", new Integer(330));
		PENN_DEP_MAP.put("{{S/S}/{S[dcl]/N}}/N", new Integer(331));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{PP/NP}}/NP", new Integer(332));
		PENN_DEP_MAP.put("NP[thr]", new Integer(333));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[dcl]\\NP}}\\{NP/NP}", new Integer(334));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[b]\\NP}", new Integer(335));
		PENN_DEP_MAP.put("{N\\N}/S[dcl]", new Integer(336));
		PENN_DEP_MAP.put("S[ng]\\NP", new Integer(337));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/S[frg]", new Integer(338));
		PENN_DEP_MAP.put("{{S\\S}/NP}/NP", new Integer(339));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[b]", new Integer(340));
		PENN_DEP_MAP.put("{{NP\\NP}\\{{NP\\NP}/NP}}/N", new Integer(341));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}}/{{S[adj]\\NP}/{S[adj]\\NP}}", new Integer(342));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{{S[to]\\NP}/NP}}/NP", new Integer(343));
		PENN_DEP_MAP.put("{S[q]/PP}/NP", new Integer(344));
		PENN_DEP_MAP.put("{S[wq]/S[q]}/{S[adj]\\NP}", new Integer(345));
		PENN_DEP_MAP.put("{S[b]\\NP}/{S[adj]\\NP}", new Integer(346));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{{S[to]\\NP}/NP}}/NP", new Integer(347));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S[poss]", new Integer(348));
		PENN_DEP_MAP.put("{NP\\NP}/S[poss]", new Integer(349));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[em]", new Integer(350));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}", new Integer(351));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[adj]\\NP}", new Integer(352));
		PENN_DEP_MAP.put("{S[q]/{S[ng]\\NP}}/NP", new Integer(353));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}/S[dcl]", new Integer(354));
		PENN_DEP_MAP.put("{{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}\\{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}}/NP", new Integer(355));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}\\NP}/{S[to]\\NP}", new Integer(356));
		PENN_DEP_MAP.put("{S/{S[b]\\NP}}/NP", new Integer(357));
		PENN_DEP_MAP.put("{{S\\S}/{S[b]\\NP}}/NP", new Integer(358));
		PENN_DEP_MAP.put("{{S[dcl]/S[dcl]}\\NP}/S[dcl]", new Integer(359));
		PENN_DEP_MAP.put("{NP/NP}\\{NP/NP}", new Integer(360));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}\\{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}/NP", new Integer(361));
		PENN_DEP_MAP.put("{{S\\S}\\NP}/{S[b]\\NP}", new Integer(362));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[adj]\\NP}}/NP", new Integer(363));
		PENN_DEP_MAP.put("{S[dcl]/PP}/NP", new Integer(364));
		PENN_DEP_MAP.put("{PP/PP}/{PP/PP}", new Integer(365));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[dcl]", new Integer(366));
		PENN_DEP_MAP.put("{S\\NP}/{S\\NP}", new Integer(367));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[pt]\\NP}}/NP", new Integer(368));
		PENN_DEP_MAP.put("{{NP[nb]/N}\\{NP[nb]/N}}/{NP[nb]/N}", new Integer(369));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}", new Integer(370));
		PENN_DEP_MAP.put("{{S\\S}/{S[to]\\NP}}/NP", new Integer(371));
		PENN_DEP_MAP.put("S[wq]/{S[adj]\\NP}", new Integer(372));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/{S[adj]\\NP}", new Integer(373));
		PENN_DEP_MAP.put("{S[dcl]\\PP}/S[qem]", new Integer(374));
		PENN_DEP_MAP.put("{NP[nb]/N}/PP", new Integer(375));
		PENN_DEP_MAP.put("{{NP/NP}\\{NP/NP}}/{NP/NP}", new Integer(376));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}\\NP", new Integer(377));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}/S[em]", new Integer(378));
		PENN_DEP_MAP.put("{S/S}\\NP", new Integer(379));
		PENN_DEP_MAP.put("{S[q]/{S[adj]\\NP}}/NP[expl]", new Integer(380));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/NP", new Integer(381));
		PENN_DEP_MAP.put("S[frg]/PP", new Integer(382));
		PENN_DEP_MAP.put("{S[dcl]\\{S[b]\\NP}}/{S[adj]\\NP}", new Integer(383));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/NP", new Integer(384));
		PENN_DEP_MAP.put("{S[dcl]\\{S[dcl]\\NP}}\\NP", new Integer(385));
		PENN_DEP_MAP.put("{S[adj]\\S[adj]}/NP", new Integer(386));
		PENN_DEP_MAP.put("S[wq]/S[q]", new Integer(387));
		PENN_DEP_MAP.put("S[wq]/PP", new Integer(388));
		PENN_DEP_MAP.put("{{S[qem]/{S[dcl]\\NP}}/N}/{S[adj]\\NP}", new Integer(389));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}/NP", new Integer(390));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/{{N/N}\\{N/N}}", new Integer(391));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/N", new Integer(392));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[poss]}/NP", new Integer(393));
		PENN_DEP_MAP.put("{S[dcl]\\S[dcl]}\\NP", new Integer(394));
		PENN_DEP_MAP.put("{{S/S}/{S/S}}/{S[asup]\\NP}", new Integer(395));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/NP}/NP", new Integer(396));
		PENN_DEP_MAP.put("{S[dcl]\\{S[adj]\\NP}}\\NP", new Integer(397));
		PENN_DEP_MAP.put("NP[expl]", new Integer(398));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}", new Integer(399));
		PENN_DEP_MAP.put("{S[qem]/{{S[b]\\NP}/NP}}/NP", new Integer(400));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/PP}\\NP", new Integer(401));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{NP\\NP}/NP}}/N", new Integer(402));
		PENN_DEP_MAP.put("S/{{S[to]\\NP}/NP}", new Integer(403));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[adj]\\NP}}/NP", new Integer(404));
		PENN_DEP_MAP.put("{S\\NP}/N[num]", new Integer(405));
		PENN_DEP_MAP.put("{{S/S}/{S[ng]\\NP}}/NP", new Integer(406));
		PENN_DEP_MAP.put("{NP\\NP}/S[b]", new Integer(407));
		PENN_DEP_MAP.put("{{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}}/{{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}}", new Integer(408));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[adj]\\NP}}/PP}/NP", new Integer(409));
		PENN_DEP_MAP.put("S[dcl]/{S[pss]\\NP}", new Integer(410));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[adj]\\NP}}/PP", new Integer(411));
		PENN_DEP_MAP.put("{S[b]\\S[dcl]}\\NP", new Integer(412));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[pt]", new Integer(413));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[adj]\\NP}}/PP}/PP", new Integer(414));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[bem]}/PP", new Integer(415));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[dcl]\\NP}", new Integer(416));
		PENN_DEP_MAP.put("{NP/NP}/NP", new Integer(417));
		PENN_DEP_MAP.put("{S[pt]\\NP}/{S[pt]\\NP}", new Integer(418));
		PENN_DEP_MAP.put("{NP\\NP}/S[adj]", new Integer(419));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/S[dcl]}/{S[adj]\\NP}}/NP", new Integer(420));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/{S[ng]\\NP}}/{S[ng]\\NP}}/NP", new Integer(421));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[b]\\NP}}/NP", new Integer(422));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[bem]", new Integer(423));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[pss]\\NP}", new Integer(424));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}/PP", new Integer(425));
		PENN_DEP_MAP.put("{S[dcl]\\{S[to]\\NP}}/{S[to]\\NP}", new Integer(426));
		PENN_DEP_MAP.put("N[num]", new Integer(427));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/N[num]", new Integer(428));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[em]}/NP", new Integer(429));
		PENN_DEP_MAP.put("{S[pt]\\NP}/S[qem]", new Integer(430));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\NP}/{S[to]\\NP}}/NP", new Integer(431));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/S[em]}/PP}/NP[expl]", new Integer(432));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}\\{S[adj]\\NP}", new Integer(433));
		PENN_DEP_MAP.put("{NP\\NP}/{S[b]/NP}", new Integer(434));
		PENN_DEP_MAP.put("{{S[to]\\NP}/{S[to]\\NP}}/{S[b]\\NP}", new Integer(435));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[asup]\\NP}", new Integer(436));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S[pss]", new Integer(437));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\PP}\\{S[adj]\\NP}", new Integer(438));
		PENN_DEP_MAP.put("N/N", new Integer(439));
		PENN_DEP_MAP.put("{PP\\PP}/{PP\\PP}", new Integer(440));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/N", new Integer(441));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}/{S[adj]\\NP}", new Integer(442));
		PENN_DEP_MAP.put("{N/N}/N[num]", new Integer(443));
		PENN_DEP_MAP.put("{S\\S}/{S[pss]\\NP}", new Integer(444));
		PENN_DEP_MAP.put("N/S", new Integer(445));
		PENN_DEP_MAP.put("{S[dcl]\\{S[to]\\NP}}/{S[b]\\NP}", new Integer(446));
		PENN_DEP_MAP.put("{S[pss]\\NP}/S[for]", new Integer(447));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}", new Integer(448));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[ng]\\NP}", new Integer(449));
		PENN_DEP_MAP.put("{S/S}/PP", new Integer(450));
		PENN_DEP_MAP.put("{S[dcl]\\{S[b]\\NP}}\\NP", new Integer(451));
		PENN_DEP_MAP.put("{{S[b]\\NP}\\NP}/S[em]", new Integer(452));
		PENN_DEP_MAP.put("{S[adj]\\S[adj]}/S[dcl]", new Integer(453));
		PENN_DEP_MAP.put("{{S/S}/PP}/NP", new Integer(454));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[qem]", new Integer(455));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/S[dcl]}/PP}/NP", new Integer(456));
		PENN_DEP_MAP.put("{NP/NP}/PP", new Integer(457));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[adj]\\NP}", new Integer(458));
		PENN_DEP_MAP.put("{{S[b]\\NP}/NP}/", new Integer(459));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[qem]}/{S[adj]\\NP}", new Integer(460));
		PENN_DEP_MAP.put("{S[adj]\\NP}/S[em]", new Integer(461));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/{S[to]\\NP}}/NP}/NP", new Integer(462));
		PENN_DEP_MAP.put("{S[qem]/S[dcl]}/{S[adj]\\NP}", new Integer(463));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[to]\\NP}}/PP}/{S[adj]\\NP}", new Integer(464));
		PENN_DEP_MAP.put("{S[adj]\\NP}/N[num]", new Integer(465));
		PENN_DEP_MAP.put("N/N[num]", new Integer(466));
		PENN_DEP_MAP.put("{{NP\\NP}\\{{NP\\NP}/NP}}/{S[dcl]\\NP}", new Integer(467));
		PENN_DEP_MAP.put("conj/PP", new Integer(468));
		PENN_DEP_MAP.put("{PP\\PP}/{S[adj]\\NP}", new Integer(469));
		PENN_DEP_MAP.put("{{NP\\NP}\\S[dcl]}/NP", new Integer(470));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/PP}/{S[adj]\\NP}}/NP", new Integer(471));
		PENN_DEP_MAP.put("{{S/S}/{S[pt]\\NP}}/NP", new Integer(472));
		PENN_DEP_MAP.put("S[to]\\{S[to]\\NP}", new Integer(473));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[thr]}/S[dcl]}/NP", new Integer(474));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[em]}/PP", new Integer(475));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}\\NP", new Integer(476));
		PENN_DEP_MAP.put("S/S[em]", new Integer(477));
		PENN_DEP_MAP.put("{S[dcl]/{S[adj]\\NP}}/NP", new Integer(478));
		PENN_DEP_MAP.put("{PP/{S[to]\\NP}}/NP", new Integer(479));
		PENN_DEP_MAP.put("{S[adj]\\NP}/{S[adj]\\NP}", new Integer(480));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/PP}/{S[to]\\NP}", new Integer(481));
		PENN_DEP_MAP.put("S\\S", new Integer(482));
		PENN_DEP_MAP.put("S[dcl]/{S[to]\\NP}", new Integer(483));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\NP}/{S[ng]\\NP}", new Integer(484));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/NP}/{S[adj]\\NP}}/NP[expl]", new Integer(485));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}/{S[asup]\\NP}", new Integer(486));
		PENN_DEP_MAP.put("{{S[b]\\NP}/PP}/NP", new Integer(487));
		PENN_DEP_MAP.put("{NP\\NP}/S[dcl]", new Integer(488));
		PENN_DEP_MAP.put("{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/{S[asup]\\NP}", new Integer(489));
		PENN_DEP_MAP.put("NP/{S[dcl]\\NP}", new Integer(490));
		PENN_DEP_MAP.put("{N\\N}/NP", new Integer(491));
		PENN_DEP_MAP.put("{S[dcl]\\{S[b]\\NP}}/NP", new Integer(492));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[dcl]/N}}/N", new Integer(493));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/S[for]}/{S[adj]\\NP}}/NP[expl]", new Integer(494));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}}\\NP}/{S[to]\\NP}", new Integer(495));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/{S[dcl]\\NP}", new Integer(496));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(497));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[to]\\NP}}/PP", new Integer(498));
		PENN_DEP_MAP.put("{{S/S}/{S/S}}/NP", new Integer(499));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/PP", new Integer(500));
		PENN_DEP_MAP.put("{NP[nb]/N}\\NP", new Integer(501));
		PENN_DEP_MAP.put("{NP/NP}/S[dcl]", new Integer(502));
		PENN_DEP_MAP.put("{S[dcl]\\{S[ng]\\NP}}/{S[pt]\\NP}", new Integer(503));
		PENN_DEP_MAP.put("{S[pss]\\NP}\\{S[adj]\\NP}", new Integer(504));
		PENN_DEP_MAP.put("{S\\S}/S[dcl]", new Integer(505));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[pss]\\NP}}/NP", new Integer(506));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/PP}/NP", new Integer(507));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}/{S[ng]\\NP}", new Integer(508));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[ng]\\NP}}/NP", new Integer(509));
		PENN_DEP_MAP.put("{PP\\PP}/NP", new Integer(510));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[qem]}/NP", new Integer(511));
		PENN_DEP_MAP.put("S[dcl]\\NP[thr]", new Integer(512));
		PENN_DEP_MAP.put("{{{NP\\NP}/PP}/PP}/NP", new Integer(513));
		PENN_DEP_MAP.put("{S\\S}/{S[adj]\\NP}", new Integer(514));
		PENN_DEP_MAP.put("{{S/S}/{S/S}}/{S[adj]\\NP}", new Integer(515));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[ng]", new Integer(516));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]", new Integer(517));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/{S[to]\\NP}}/PP}/NP", new Integer(518));
		PENN_DEP_MAP.put("{{N/N}\\NP}/N[num]", new Integer(519));
		PENN_DEP_MAP.put("S[wq]/{S[b]/NP}", new Integer(520));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/{S[dcl]\\NP}", new Integer(521));
		PENN_DEP_MAP.put("{S[pt]\\NP}/{S[ng]\\NP}", new Integer(522));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[pt]\\NP}}/NP", new Integer(523));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}}/NP", new Integer(524));
		PENN_DEP_MAP.put("S[em]/S[b]", new Integer(525));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}/N", new Integer(526));
		PENN_DEP_MAP.put("{S[dcl]\\S[for]}/NP", new Integer(527));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}\\PP", new Integer(528));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}/{S[pt]\\NP}", new Integer(529));
		PENN_DEP_MAP.put("N/S[em]", new Integer(530));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}", new Integer(531));
		PENN_DEP_MAP.put("{S[inv]/NP}/NP[thr]", new Integer(532));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[qem]", new Integer(533));
		PENN_DEP_MAP.put("{N\\N}/{N\\N}", new Integer(534));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S[dcl]", new Integer(535));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[pss]", new Integer(536));
		PENN_DEP_MAP.put("{S[dcl]\\{S[dcl]\\NP}}/NP", new Integer(537));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}/{S[ng]\\NP}}/NP", new Integer(538));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/PP}/PP", new Integer(539));
		PENN_DEP_MAP.put("{N\\N}/{S[pss]\\NP}", new Integer(540));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}", new Integer(541));
		PENN_DEP_MAP.put("S[qem]/S[dcl]", new Integer(542));
		PENN_DEP_MAP.put("S[dcl]/S[inv]", new Integer(543));
		PENN_DEP_MAP.put("{{S[b]\\NP}/PP}/PP", new Integer(544));
		PENN_DEP_MAP.put("{PP/NP}/{PP/NP}", new Integer(545));
		PENN_DEP_MAP.put("{S[dcl]\\S}/NP", new Integer(546));
		PENN_DEP_MAP.put("{{{{S[b]\\NP}/PP}/PP}/{S[adj]\\NP}}/NP", new Integer(547));
		PENN_DEP_MAP.put("{S[inv]/{S[b]\\NP}}/NP", new Integer(548));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/NP", new Integer(549));
		PENN_DEP_MAP.put("{{:\\NP}/PP}/NP", new Integer(550));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/PP}/PP", new Integer(551));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[wq]}/S[qem]", new Integer(552));
		PENN_DEP_MAP.put("{NP/NP}\\{S[adj]\\NP}", new Integer(553));
		PENN_DEP_MAP.put("{PP/{S[b]\\NP}}/NP", new Integer(554));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[ng]\\NP}", new Integer(555));
		PENN_DEP_MAP.put("S[pt]\\NP", new Integer(556));
		PENN_DEP_MAP.put("{{N/N}/PP}/{S[adj]\\NP}", new Integer(557));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\NP}/NP", new Integer(558));
		PENN_DEP_MAP.put("{{PP\\PP}\\{PP\\PP}}/{S[dcl]\\NP}", new Integer(559));
		PENN_DEP_MAP.put("{S/S}/{S[b]\\NP}", new Integer(560));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{{S[to]\\NP}/NP}}/{S[adj]\\NP}", new Integer(561));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/NP", new Integer(562));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}", new Integer(563));
		PENN_DEP_MAP.put("{NP/NP}\\NP", new Integer(564));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[to]\\NP}}/PP}/NP", new Integer(565));
		PENN_DEP_MAP.put("S[em]/NP", new Integer(566));
		PENN_DEP_MAP.put("N\\N[num]", new Integer(567));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[to]\\NP}}\\{{NP\\NP}/NP}", new Integer(568));
		PENN_DEP_MAP.put("{S\\S}/PP", new Integer(569));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[adj]\\NP}", new Integer(570));
		PENN_DEP_MAP.put("S[em]/S", new Integer(571));
		PENN_DEP_MAP.put("{NP\\NP}/{S[to]\\NP}", new Integer(572));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S}/NP", new Integer(573));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}/N", new Integer(574));
		PENN_DEP_MAP.put("{{S\\NP}/{S[dcl]\\N}}/N", new Integer(575));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/PP}/NP", new Integer(576));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{S[adj]\\NP}\\{S[adj]\\NP}}", new Integer(577));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/S[for]}/NP}/NP[expl]", new Integer(578));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/S[dcl]", new Integer(579));
		PENN_DEP_MAP.put("{S/S}/{S[adj]\\NP}", new Integer(580));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/{N/N}", new Integer(581));
		PENN_DEP_MAP.put("{S\\S}/S[frg]", new Integer(582));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\NP}/{S[b]\\NP}", new Integer(583));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/{S[b]\\NP}}/{S[b]\\NP}}/NP", new Integer(584));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[b]\\NP}}/NP", new Integer(585));
		PENN_DEP_MAP.put("S[frg]/NP", new Integer(586));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[em]}/{S[adj]\\NP}", new Integer(587));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/S[em]}/PP", new Integer(588));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[adj]", new Integer(589));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/S[for]}/{S[adj]\\NP}}/NP[expl]", new Integer(590));
		PENN_DEP_MAP.put("S[wq]/NP", new Integer(591));
		PENN_DEP_MAP.put("S[pss]\\NP", new Integer(592));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S[inv]", new Integer(593));
		PENN_DEP_MAP.put("{S[qem]/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}", new Integer(594));
		PENN_DEP_MAP.put("{{S[qem]/S[wq]}/{S[dcl]/N}}/N", new Integer(595));
		PENN_DEP_MAP.put("{S\\S}/{S[ng]\\NP}", new Integer(596));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[as]", new Integer(597));
		PENN_DEP_MAP.put("{S[em]\\NP}/{S[b]\\NP}", new Integer(598));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[for]", new Integer(599));
		PENN_DEP_MAP.put("{S[q]/S}/NP", new Integer(600));
		PENN_DEP_MAP.put("{S[b]\\NP}/S", new Integer(601));
		PENN_DEP_MAP.put("PP/S[wq]", new Integer(602));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\NP}/S[em]", new Integer(603));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S}/NP", new Integer(604));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/NP}/{S[dcl]\\NP}", new Integer(605));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}/NP}/N", new Integer(606));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\NP}/PP", new Integer(607));
		PENN_DEP_MAP.put("{S[dcl]\\S[em]}/S[qem]", new Integer(608));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/PP", new Integer(609));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S[frg]", new Integer(610));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{{S[to]\\NP}/NP}}/NP", new Integer(611));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/{S[to]\\NP}}/NP}/NP[expl]", new Integer(612));
		PENN_DEP_MAP.put("{S[ng]\\NP}/{S[to]\\NP}", new Integer(613));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/PP}/{S[adj]\\NP}", new Integer(614));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S[qem]", new Integer(615));
		PENN_DEP_MAP.put("{S/S}/S[em]", new Integer(616));
		PENN_DEP_MAP.put("NP/{S[b]\\NP}", new Integer(617));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[q]", new Integer(618));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[wq]", new Integer(619));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[to]\\NP}", new Integer(620));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[dcl]", new Integer(621));
		PENN_DEP_MAP.put("S[em]/S[frg]", new Integer(622));
		PENN_DEP_MAP.put("{{PP/NP}/{S[adj]\\NP}}/N", new Integer(623));
		PENN_DEP_MAP.put("{NP/{S[dcl]\\N}}/N", new Integer(624));
		PENN_DEP_MAP.put("{{S/S}/{S[to]\\N}}/N", new Integer(625));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}", new Integer(626));
		PENN_DEP_MAP.put("{NP\\NP}/{S[dcl]/S[dcl]}", new Integer(627));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[b]\\NP}", new Integer(628));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[pss]", new Integer(629));
		PENN_DEP_MAP.put("{N/N}/N", new Integer(630));
		PENN_DEP_MAP.put("{S[em]/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}", new Integer(631));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[ng]\\NP}}/S[em]", new Integer(632));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/PP", new Integer(633));
		PENN_DEP_MAP.put("{{S\\S}/{S\\S}}/S[dcl]", new Integer(634));
		PENN_DEP_MAP.put("PP/{S[adj]\\NP}", new Integer(635));
		PENN_DEP_MAP.put("{N/N}/NP", new Integer(636));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}\\{S[adj]\\NP}", new Integer(637));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[dcl]}/NP", new Integer(638));
		PENN_DEP_MAP.put("{{S/S}/{S/S}}/S[dcl]", new Integer(639));
		PENN_DEP_MAP.put("S[qem]/{S[dcl]\\NP}", new Integer(640));
		PENN_DEP_MAP.put("S[wq]/{S[b]\\NP}", new Integer(641));
		PENN_DEP_MAP.put("S[intj]", new Integer(642));
		PENN_DEP_MAP.put("{PP\\PP}/{S[b]\\NP}", new Integer(643));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[bem]}/PP", new Integer(644));
		PENN_DEP_MAP.put("{NP/PP}/N", new Integer(645));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}", new Integer(646));
		PENN_DEP_MAP.put("{{S[pss]\\NP}\\NP}/{S[pt]\\NP}", new Integer(647));
		PENN_DEP_MAP.put("S[wq]/{S[dcl]\\NP}", new Integer(648));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/S[dcl]", new Integer(649));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[thr]}/{S[ng]\\NP}}/NP", new Integer(650));
		PENN_DEP_MAP.put("{S/S}/S[frg]", new Integer(651));
		PENN_DEP_MAP.put("{{{N/N}/{N/N}}/PP}/{S[adj]\\NP}", new Integer(652));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\NP}/S", new Integer(653));
		PENN_DEP_MAP.put("{S/S}/S[qem]", new Integer(654));
		PENN_DEP_MAP.put("{NP\\NP}/PP", new Integer(655));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S}/{S[adj]\\NP}", new Integer(656));
		PENN_DEP_MAP.put("{NP\\NP}/S[wq]", new Integer(657));
		PENN_DEP_MAP.put("{S/S}/{S[pss]\\NP}", new Integer(658));
		PENN_DEP_MAP.put("{NP/{S[dcl]/N}}/N", new Integer(659));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[em]}/PP", new Integer(660));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/PP}/PP", new Integer(661));
		PENN_DEP_MAP.put("{S[em]\\NP}/S[dcl]", new Integer(662));
		PENN_DEP_MAP.put("{S[qem]/S[dcl]}/N", new Integer(663));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}\\{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(664));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[for]}/NP", new Integer(665));
		PENN_DEP_MAP.put("{S/S}/S[inv]", new Integer(666));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}/{S[asup]\\NP}", new Integer(667));
		PENN_DEP_MAP.put("{N\\N}/{S[b]\\NP}", new Integer(668));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[to]\\NP}", new Integer(669));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[dcl]}/{S[adj]\\NP}", new Integer(670));
		PENN_DEP_MAP.put("{S[dcl]\\{S[adj]\\NP}}/S[qem]", new Integer(671));
		PENN_DEP_MAP.put("{{NP\\NP}/NP}/{S[adj]\\NP}", new Integer(672));
		PENN_DEP_MAP.put("{{S/S}/S[dcl]}/{S[adj]\\NP}", new Integer(673));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/PP", new Integer(674));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[wq]", new Integer(675));
		PENN_DEP_MAP.put("{S\\S}/{S[dcl]\\NP}", new Integer(676));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/PP", new Integer(677));
		PENN_DEP_MAP.put("{N/N}/PP", new Integer(678));
		PENN_DEP_MAP.put("{NP\\NP}/S[pss]", new Integer(679));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/NP", new Integer(680));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/{{S[to]\\NP}/NP}}/NP}/NP", new Integer(681));
		PENN_DEP_MAP.put("{{S/S}/NP}/NP", new Integer(682));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/S[qem]}/{S[to]\\NP}", new Integer(683));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/PP}/PP}/NP", new Integer(684));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[adj]\\NP}}/NP}/{S[b]\\NP}", new Integer(685));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[dcl]}/{S[adj]\\NP}", new Integer(686));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[for]}/NP", new Integer(687));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/{S[to]\\NP}}/NP}/NP", new Integer(688));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}/PP}/NP", new Integer(689));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[to]\\NP}", new Integer(690));
		PENN_DEP_MAP.put("{{NP\\NP}/N}\\NP", new Integer(691));
		PENN_DEP_MAP.put("{S[wq]/{S[dcl]/N}}/N", new Integer(692));
		PENN_DEP_MAP.put("{S[adj]\\NP}/N", new Integer(693));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/PP}/{S[to]\\NP}", new Integer(694));
		PENN_DEP_MAP.put("{PP\\PP}/{S[ng]\\NP}", new Integer(695));
		PENN_DEP_MAP.put("S[wq]/{S[q]/{S[adj]\\NP}}", new Integer(696));
		PENN_DEP_MAP.put("{{S/S}/{S[to]\\NP}}/NP", new Integer(697));
		PENN_DEP_MAP.put("{N/N}/{S[b]\\NP}", new Integer(698));
		PENN_DEP_MAP.put("{S[adj]\\NP}/S", new Integer(699));
		PENN_DEP_MAP.put("{S[q]/NP}/NP", new Integer(700));
		PENN_DEP_MAP.put("{NP\\NP}/NP", new Integer(701));
		PENN_DEP_MAP.put("{{S/S}/NP}/{S[adj]\\NP}", new Integer(702));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[dcl]}/PP", new Integer(703));
		PENN_DEP_MAP.put("{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}", new Integer(704));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[to]\\NP}}/N", new Integer(705));
		PENN_DEP_MAP.put("{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}\\NP", new Integer(706));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[dcl]\\NP}", new Integer(707));
		PENN_DEP_MAP.put("{S[for]/{{S[to]\\NP}/NP}}/NP", new Integer(708));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/PP}/PP}/NP", new Integer(709));
		PENN_DEP_MAP.put("S[em]/S[dcl]", new Integer(710));
		PENN_DEP_MAP.put("S[adj]\\NP", new Integer(711));
		PENN_DEP_MAP.put("PP/S[intj]", new Integer(712));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/{S[adj]\\NP}", new Integer(713));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/PP}/{S[to]\\NP}", new Integer(714));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[ng]", new Integer(715));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[pt]\\NP}", new Integer(716));
		PENN_DEP_MAP.put("{S[ng]\\NP}/{S[dcl]\\NP}", new Integer(717));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}", new Integer(718));
		PENN_DEP_MAP.put("S[b]", new Integer(719));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[dcl]}/NP", new Integer(720));
		PENN_DEP_MAP.put("{{N\\N}\\{N\\N}}/NP", new Integer(721));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[pt]\\NP}", new Integer(722));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}/NP", new Integer(723));
		PENN_DEP_MAP.put("{S[dcl]\\{S[to]\\NP}}/NP", new Integer(724));
		PENN_DEP_MAP.put("{{NP\\NP}/{{S[b]\\NP}/NP}}/NP", new Integer(725));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/PP", new Integer(726));
		PENN_DEP_MAP.put("{PP/N}\\NP", new Integer(727));
		PENN_DEP_MAP.put("NP\\N", new Integer(728));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/NP}/{S[adj]\\NP}", new Integer(729));
		PENN_DEP_MAP.put("{S/S}/{S[dcl]/S[dcl]}", new Integer(730));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/S[dcl]}/{S[adj]\\NP}}/NP[expl]", new Integer(731));
		PENN_DEP_MAP.put("{{NP\\NP}/PP}/NP", new Integer(732));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}/NP", new Integer(733));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}\\NP", new Integer(734));
		PENN_DEP_MAP.put("PP/{S[pss]\\NP}", new Integer(735));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/NP", new Integer(736));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[dcl]}/NP", new Integer(737));
		PENN_DEP_MAP.put("{{S[to]\\NP}\\{S[adj]\\NP}}/{S[b]\\NP}", new Integer(738));
		PENN_DEP_MAP.put("{S[adj]\\NP}/{NP\\NP}", new Integer(739));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}/NP", new Integer(740));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}", new Integer(741));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/PP}/{PP/NP}", new Integer(742));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[pss]", new Integer(743));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}/{{NP\\NP}/{NP\\NP}}", new Integer(744));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/{S[b]\\NP}", new Integer(745));
		PENN_DEP_MAP.put("S[em]/S[wq]", new Integer(746));
		PENN_DEP_MAP.put("{N/N}/{S\\NP}", new Integer(747));
		PENN_DEP_MAP.put("{S\\NP}\\{S\\NP}", new Integer(748));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[wq]", new Integer(749));
		PENN_DEP_MAP.put("{{S[b]\\NP}/NP}/{S[dcl]\\NP}", new Integer(750));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}\\NP", new Integer(751));
		PENN_DEP_MAP.put("{S[adj]\\NP}\\{S[adj]\\NP}", new Integer(752));
		PENN_DEP_MAP.put("{N/{S[adj]\\NP}}/NP", new Integer(753));
		PENN_DEP_MAP.put("S[inv]/NP", new Integer(754));
		PENN_DEP_MAP.put("{S[dcl]/{S[pss]\\NP}}/NP", new Integer(755));
		PENN_DEP_MAP.put("PP/NP", new Integer(756));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[em]}/{S[adj]\\NP}", new Integer(757));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/S[dcl]", new Integer(758));
		PENN_DEP_MAP.put("{S[dcl]\\{S[pss]\\NP}}/{S[b]\\NP}", new Integer(759));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}/NP", new Integer(760));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(761));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/S[dcl]}\\{{NP\\NP}/NP}", new Integer(762));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[asup]\\NP}", new Integer(763));
		PENN_DEP_MAP.put("{S[dcl]\\{S[to]\\NP}}/PP", new Integer(764));
		PENN_DEP_MAP.put("{S/S}/{S[ng]\\NP}", new Integer(765));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[dcl]}/PP", new Integer(766));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/NP", new Integer(767));
		PENN_DEP_MAP.put("{{S[to]\\NP}/NP}/{S[b]\\NP}", new Integer(768));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/S[dcl]}/S[dcl]", new Integer(769));
		PENN_DEP_MAP.put("{S[wq]/S[dcl]}/{S[adj]\\NP}", new Integer(770));
		PENN_DEP_MAP.put("{{S/S}\\{S[adj]\\NP}}/S[dcl]", new Integer(771));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}/PP", new Integer(772));
		PENN_DEP_MAP.put("S/NP", new Integer(773));
		PENN_DEP_MAP.put("{S[q]\\S[dcl]}/NP", new Integer(774));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[bem]}/NP", new Integer(775));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]", new Integer(776));
		PENN_DEP_MAP.put("PP/PP", new Integer(777));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[to]\\NP}", new Integer(778));
		PENN_DEP_MAP.put("{S[pss]\\NP}/{S[pt]\\NP}", new Integer(779));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[to]\\NP}}/NP", new Integer(780));
		PENN_DEP_MAP.put("S[as]/S[poss]", new Integer(781));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]", new Integer(782));
		PENN_DEP_MAP.put("{N\\N}/PP", new Integer(783));
		PENN_DEP_MAP.put("{{N\\N}/{S[dcl]\\NP}}\\{NP/NP}", new Integer(784));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\NP}/{S[pss]\\NP}", new Integer(785));
		PENN_DEP_MAP.put("{{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}}\\{S[adj]\\NP}", new Integer(786));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP[expl]}/S[q]}/S[qem]}/{S[to]\\NP}", new Integer(787));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[ng]\\NP}}/PP", new Integer(788));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[b]", new Integer(789));
		PENN_DEP_MAP.put("{N/N}\\NP", new Integer(790));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[to]", new Integer(791));
		PENN_DEP_MAP.put("{{S\\S}\\{S\\S}}/N", new Integer(792));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}/{S[b]\\NP}", new Integer(793));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/N", new Integer(794));
		PENN_DEP_MAP.put("{N/{S[dcl]\\N}}/N", new Integer(795));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}", new Integer(796));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[dcl]", new Integer(797));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[ng]\\NP}}/NP", new Integer(798));
		PENN_DEP_MAP.put("{S[q]/NP}/NP[thr]", new Integer(799));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[b]\\NP}}\\NP}/{S[b]\\NP}", new Integer(800));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[to]\\NP}}/NP", new Integer(801));
		PENN_DEP_MAP.put("{S[adj]\\NP}/{{S[to]\\NP}/NP}", new Integer(802));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}/N[num]", new Integer(803));
		PENN_DEP_MAP.put("{S[dcl]\\{S[adj]\\NP}}/S[em]", new Integer(804));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}/N", new Integer(805));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S", new Integer(806));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}/S[dcl]}\\{{NP\\NP}/NP}}/N", new Integer(807));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}/{S[pss]\\NP}}/NP", new Integer(808));
		PENN_DEP_MAP.put("{S[wq]/PP}/N", new Integer(809));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/N", new Integer(810));
		PENN_DEP_MAP.put("{S[pt]\\NP}/PP", new Integer(811));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\NP}/PP", new Integer(812));
		PENN_DEP_MAP.put("S[adj]/S[adj]", new Integer(813));
		PENN_DEP_MAP.put("{{{N/N}/{N/N}}/{{N/N}/{N/N}}}\\{S[adj]\\NP}", new Integer(814));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[ng]\\NP}", new Integer(815));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}/PP}/NP", new Integer(816));
		PENN_DEP_MAP.put("{S[adj]\\NP}/{S[ng]\\NP}", new Integer(817));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[pt]\\NP}", new Integer(818));
		PENN_DEP_MAP.put("{S\\NP}/NP", new Integer(819));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]", new Integer(820));
		PENN_DEP_MAP.put("{PP/NP}/NP", new Integer(821));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}}/{S[asup]\\NP}", new Integer(822));
		PENN_DEP_MAP.put("{S[dcl]\\NP[thr]}/{S[b]\\NP}", new Integer(823));
		PENN_DEP_MAP.put("{S[for]/{S[b]\\NP}}/NP", new Integer(824));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}}/N", new Integer(825));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/N", new Integer(826));
		PENN_DEP_MAP.put("{S[ng]\\NP}/{S[adj]\\NP}", new Integer(827));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}/{S[dcl]\\NP}", new Integer(828));
		PENN_DEP_MAP.put("{{N/N}\\{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(829));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/{S[ng]\\NP}", new Integer(830));
		PENN_DEP_MAP.put("S/{S[to]\\NP}", new Integer(831));
		PENN_DEP_MAP.put("{NP\\NP}\\PP", new Integer(832));
		PENN_DEP_MAP.put("{NP/NP}/N", new Integer(833));
		PENN_DEP_MAP.put("{{S[dcl]/S[dcl]}\\NP}/{S[b]\\NP}", new Integer(834));
		PENN_DEP_MAP.put("{S/S}/S[pss]", new Integer(835));
		PENN_DEP_MAP.put("{{NP/NP}\\{NP/NP}}/{{NP/NP}\\{NP/NP}}", new Integer(836));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/S[pss]", new Integer(837));
		PENN_DEP_MAP.put("{S/S}/{S[dcl]/NP}", new Integer(838));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/S[dcl]}\\{{NP\\NP}/NP}", new Integer(839));
		PENN_DEP_MAP.put("{NP\\NP}/S[inv]", new Integer(840));
		PENN_DEP_MAP.put("{N/S[dcl]}/{S[adj]\\NP}", new Integer(841));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/{S[to]\\NP}}/PP}/NP", new Integer(842));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[dcl]", new Integer(843));
		PENN_DEP_MAP.put("{S[dcl]/{S[to]\\NP}}/NP", new Integer(844));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\NP}/NP", new Integer(845));
		PENN_DEP_MAP.put("{S[wq]/{S[dcl]\\N}}/N", new Integer(846));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[adj]\\NP}}/PP", new Integer(847));
		PENN_DEP_MAP.put("{{S\\S}\\NP}/S[dcl]", new Integer(848));
		PENN_DEP_MAP.put("{NP\\NP}/{S[dcl]/NP}", new Integer(849));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]", new Integer(850));
		PENN_DEP_MAP.put("NP/{{S[dcl]\\NP}/NP}", new Integer(851));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\NP}/NP", new Integer(852));
		PENN_DEP_MAP.put("{NP\\NP}/S[qem]", new Integer(853));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[for]}/{S[adj]\\NP}", new Integer(854));
		PENN_DEP_MAP.put("{S[pt]\\NP}/NP", new Integer(855));
		PENN_DEP_MAP.put("{PP/PP}/S[dcl]", new Integer(856));
		PENN_DEP_MAP.put("NP/NP", new Integer(857));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/NP}/{S[adj]\\NP}", new Integer(858));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}\\NP", new Integer(859));
		PENN_DEP_MAP.put("{S[dcl]\\{S[pss]\\NP}}/NP", new Integer(860));
		PENN_DEP_MAP.put("{PP\\PP}/N", new Integer(861));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}\\NP}/{S[b]\\NP}", new Integer(862));
		PENN_DEP_MAP.put("{S[dcl]\\S[q]}\\NP", new Integer(863));
		PENN_DEP_MAP.put("{PP\\NP}/{S[ng]\\NP}", new Integer(864));
		PENN_DEP_MAP.put("S[adj]/NP", new Integer(865));
		PENN_DEP_MAP.put("{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/NP", new Integer(866));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[for]", new Integer(867));
		PENN_DEP_MAP.put("{S\\S}/S[b]", new Integer(868));
		PENN_DEP_MAP.put("{S[dcl]\\{S[ng]\\NP}}/NP", new Integer(869));
		PENN_DEP_MAP.put("{{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}\\{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}}/NP", new Integer(870));
		PENN_DEP_MAP.put("{NP\\NP}\\NP", new Integer(871));
		PENN_DEP_MAP.put("conj\\conj", new Integer(872));
		PENN_DEP_MAP.put("{{{S/S}\\{S/S}}\\{{S/S}\\{S/S}}}/NP", new Integer(873));
		PENN_DEP_MAP.put("{S[b]/NP}/NP", new Integer(874));
		PENN_DEP_MAP.put("{S/PP}/{S[asup]\\NP}", new Integer(875));
		PENN_DEP_MAP.put("{S/S}/S[q]", new Integer(876));
		PENN_DEP_MAP.put("{S[ng]/PP}/NP", new Integer(877));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP[thr]}/NP", new Integer(878));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/S[em]", new Integer(879));
		PENN_DEP_MAP.put("{S[dcl]/NP[expl]}/NP", new Integer(880));
		PENN_DEP_MAP.put("{S[ng]\\NP}\\{S[adj]\\NP}", new Integer(881));
		PENN_DEP_MAP.put("{S[b]\\NP}/{S[ng]\\NP}", new Integer(882));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/{S[to]\\NP}", new Integer(883));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/NP", new Integer(884));
		PENN_DEP_MAP.put("{S[b]\\NP}/S[em]", new Integer(885));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/S[for]", new Integer(886));
		PENN_DEP_MAP.put("{N\\NP}/{S[to]\\NP}", new Integer(887));
		PENN_DEP_MAP.put("{S[dcl]\\S[dcl]}/NP", new Integer(888));
		PENN_DEP_MAP.put("S/N", new Integer(889));
		PENN_DEP_MAP.put("{S\\S}/{{S[to]\\NP}/NP}", new Integer(890));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}/S[dcl]}/N", new Integer(891));
		PENN_DEP_MAP.put("S/S", new Integer(892));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[dcl]\\NP}", new Integer(893));
		PENN_DEP_MAP.put("{S[adj]\\NP}/{S[to]\\NP}", new Integer(894));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[dcl]}/NP", new Integer(895));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/PP}/PP", new Integer(896));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[dcl]\\NP}", new Integer(897));
		PENN_DEP_MAP.put("{S[dcl]/{S[pt]\\NP}}/NP", new Integer(898));
		PENN_DEP_MAP.put("NP/{S[adj]\\NP}", new Integer(899));
		PENN_DEP_MAP.put("{S[pt]\\NP}/{S[b]\\NP}", new Integer(900));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/PP}/NP}/{S[adj]\\NP}", new Integer(901));
		PENN_DEP_MAP.put("{S[adj]\\NP}/S[for]", new Integer(902));
		PENN_DEP_MAP.put("S[wq]/{S[ng]\\NP}", new Integer(903));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/{S[asup]\\NP}", new Integer(904));
		PENN_DEP_MAP.put("{{{NP\\NP}/{NP\\NP}}\\{{NP\\NP}/{NP\\NP}}}/{{NP\\NP}/{NP\\NP}}", new Integer(905));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[inv]", new Integer(906));
		PENN_DEP_MAP.put("{S[adj]\\NP}/{S[pss]\\NP}", new Integer(907));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[to]\\NP}", new Integer(908));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[qem]", new Integer(909));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/PP}/NP}/NP", new Integer(910));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}", new Integer(911));
		PENN_DEP_MAP.put("{{NP\\NP}/NP}/NP", new Integer(912));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/PP", new Integer(913));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[frg]", new Integer(914));
		PENN_DEP_MAP.put("{S[dcl]\\{S[adj]\\NP}}/NP", new Integer(915));
		PENN_DEP_MAP.put("{N\\NP}/{S[b]\\NP}", new Integer(916));
		PENN_DEP_MAP.put("{PP\\PP}/S[dcl]", new Integer(917));
		PENN_DEP_MAP.put("{{{N/N}/{N/N}}\\{{N/N}/{N/N}}}/NP", new Integer(918));
		PENN_DEP_MAP.put("{N\\N}/{S[to]\\NP}", new Integer(919));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/{S[pss]\\NP}", new Integer(920));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/PP}/NP}/{S[adj]\\NP}", new Integer(921));
		PENN_DEP_MAP.put("{NP\\NP}/N", new Integer(922));
		PENN_DEP_MAP.put("{S[q]/{S[dcl]\\NP}}/NP", new Integer(923));
		PENN_DEP_MAP.put("{NP[nb]/N}/{S[adj]\\NP}", new Integer(924));
		PENN_DEP_MAP.put("S\\NP", new Integer(925));
		PENN_DEP_MAP.put("N/{{S[to]\\NP}/NP}", new Integer(926));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}\\NP", new Integer(927));
		PENN_DEP_MAP.put("PP\\PP", new Integer(928));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[dcl]}/PP", new Integer(929));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[to]\\NP}}/PP", new Integer(930));
		PENN_DEP_MAP.put("{{{S[ng]\\NP}/PP}/NP}/NP", new Integer(931));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/PP}/NP", new Integer(932));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[b]\\NP}}/NP", new Integer(933));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[adj]\\NP}", new Integer(934));
		PENN_DEP_MAP.put("{{{N/N}/{N/N}}/{{N/N}/{N/N}}}/{S[asup]\\NP}", new Integer(935));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP[expl]}/{S[to]\\NP}}/NP}/NP", new Integer(936));
		PENN_DEP_MAP.put("PP/{S[b]\\NP}", new Integer(937));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}/{S[ng]\\NP}}/NP", new Integer(938));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[qem]}/{S[adj]\\NP}", new Integer(939));
		PENN_DEP_MAP.put("{S[em]/{S[b]\\NP}}/NP", new Integer(940));
		PENN_DEP_MAP.put("{{S[qem]/S[dcl]}\\{{NP\\NP}/NP}}/N", new Integer(941));
		PENN_DEP_MAP.put("S[qem]/{S[to]\\NP}", new Integer(942));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/NP}/{S[dcl]\\NP}", new Integer(943));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/{S[b]\\NP}", new Integer(944));
		PENN_DEP_MAP.put("S[wq]", new Integer(945));
		PENN_DEP_MAP.put("{S[dcl]/{S[adj]\\NP}}/NP[expl]", new Integer(946));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}/{{S[adj]\\NP}/{S[adj]\\NP}}}/NP", new Integer(947));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[adj]\\NP}}\\NP}/{S[pss]\\NP}", new Integer(948));
		PENN_DEP_MAP.put("{{{S/S}\\{S/S}}/NP}\\NP", new Integer(949));
		PENN_DEP_MAP.put("{N\\NP}/NP", new Integer(950));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/PP}/NP", new Integer(951));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/S[em]}/NP", new Integer(952));
		PENN_DEP_MAP.put("S[wq]/S[dcl]", new Integer(953));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[em]}/{S[adj]\\NP}", new Integer(954));
		PENN_DEP_MAP.put("{NP[nb]/N}/{S[asup]\\NP}", new Integer(955));
		PENN_DEP_MAP.put("{PP/NP}/{S[adj]\\NP}", new Integer(956));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}\\{{N/N}/{N/N}}", new Integer(957));
		PENN_DEP_MAP.put("{S[dcl]/S[dcl]}/NP", new Integer(958));
		PENN_DEP_MAP.put("{{S[dcl]\\S[qem]}\\NP}/S[dcl]", new Integer(959));
		PENN_DEP_MAP.put("{NP\\NP}/{S[pt]/NP}", new Integer(960));
		PENN_DEP_MAP.put("{S[pss]\\NP}/{S[to]\\NP}", new Integer(961));
		PENN_DEP_MAP.put("S[poss]/{S[ng]\\NP}", new Integer(962));
		PENN_DEP_MAP.put("{NP\\NP}/S", new Integer(963));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}/{S[to]\\NP}}/N", new Integer(964));
		PENN_DEP_MAP.put("{S[dcl]/{S[q]/N}}/N", new Integer(965));
		PENN_DEP_MAP.put("RRB", new Integer(966));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/NP}/PP", new Integer(967));
		PENN_DEP_MAP.put("S[asup]\\NP", new Integer(968));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[dcl]/NP}", new Integer(969));
		PENN_DEP_MAP.put("S[em]/{S[dcl]\\NP}", new Integer(970));
		PENN_DEP_MAP.put("{S[ng]\\NP}/S[wq]", new Integer(971));
		PENN_DEP_MAP.put("{{PP\\PP}\\{PP\\PP}}/{S[dcl]/NP}", new Integer(972));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/S[em]}/PP", new Integer(973));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[for]", new Integer(974));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/PP}/NP}/NP", new Integer(975));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/S[for]}/{S[adj]\\NP}", new Integer(976));
		PENN_DEP_MAP.put("{{{S[pt]\\NP}/{S[to]\\NP}}/NP}/NP[expl]", new Integer(977));
		PENN_DEP_MAP.put("{S/{S[dcl]/{S[adj]\\NP}}}/{S[adj]\\NP}", new Integer(978));
		PENN_DEP_MAP.put("{S[pss]\\NP}\\NP", new Integer(979));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}\\NP}/NP", new Integer(980));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[thr]}/{S[to]\\NP}}/NP", new Integer(981));
		PENN_DEP_MAP.put("{NP\\NP}/{S[ng]\\NP}", new Integer(982));
		PENN_DEP_MAP.put("{{{NP\\NP}\\{NP\\NP}}/{S[b]\\NP}}/NP", new Integer(983));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[dcl]}/NP", new Integer(984));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/N", new Integer(985));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[to]}/NP", new Integer(986));
		PENN_DEP_MAP.put("{S[ng]\\NP}/PP", new Integer(987));
		PENN_DEP_MAP.put("{NP\\NP}/S[pt]", new Integer(988));
		PENN_DEP_MAP.put("{S/S}/S[adj]", new Integer(989));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/PP", new Integer(990));
		PENN_DEP_MAP.put("{S[adj]\\NP}/S[dcl]", new Integer(991));
		PENN_DEP_MAP.put("{S/S}/{S/S}", new Integer(992));
		PENN_DEP_MAP.put("{{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}\\NP}/{S[adj]\\NP}", new Integer(993));
		PENN_DEP_MAP.put("PP/{S[ng]\\NP}", new Integer(994));
		PENN_DEP_MAP.put("{{S\\S}\\{S\\S}}/NP", new Integer(995));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/NP}/NP", new Integer(996));
		PENN_DEP_MAP.put("{S[pss]\\NP}/{S[pss]\\NP}", new Integer(997));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/PP}/{S[adj]\\NP}", new Integer(998));
		PENN_DEP_MAP.put("{S[b]\\NP}/{S[pss]\\NP}", new Integer(999));
		PENN_DEP_MAP.put("{S[qem]/{S[dcl]\\N}}/N", new Integer(1000));
		PENN_DEP_MAP.put("{{S/S}\\NP}/NP", new Integer(1001));
		PENN_DEP_MAP.put("{S[dcl]\\S[q]}/NP", new Integer(1002));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/{NP\\NP}}/NP", new Integer(1003));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/:", new Integer(1004));
		PENN_DEP_MAP.put("{S[ng]\\NP}/{S[ng]\\NP}", new Integer(1005));
		PENN_DEP_MAP.put("S[dcl]", new Integer(1006));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}\\{{NP\\NP}/{NP\\NP}}", new Integer(1007));
		PENN_DEP_MAP.put("{{S[b]\\NP}/NP}/{S[adj]\\NP}", new Integer(1008));
		PENN_DEP_MAP.put("{S/{S[to]\\N}}/N", new Integer(1009));
		PENN_DEP_MAP.put("{S[dcl]\\S[qem]}/{S[to]\\NP}", new Integer(1010));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}\\{{S[adj]\\NP}/{S[adj]\\NP}}", new Integer(1011));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[thr]}/PP}/NP", new Integer(1012));
		PENN_DEP_MAP.put("NP/{S[dcl]/NP}", new Integer(1013));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[b]\\NP}}/NP[expl]", new Integer(1014));
		PENN_DEP_MAP.put("{S[b]\\NP}\\NP", new Integer(1015));
		PENN_DEP_MAP.put("{S[pt]\\NP}/{S[pss]\\NP}", new Integer(1016));
		PENN_DEP_MAP.put("{NP\\NP}\\{NP\\NP}", new Integer(1017));
		PENN_DEP_MAP.put("N/S[qem]", new Integer(1018));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/{S[pt]\\NP}", new Integer(1019));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[adj]\\NP}}/NP", new Integer(1020));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/PP}/{S[adj]\\NP}", new Integer(1021));
		PENN_DEP_MAP.put("{S/S}/{S[asup]\\NP}", new Integer(1022));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[asup]\\NP}", new Integer(1023));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/PP}/NP}/{S[adj]\\NP}", new Integer(1024));
		PENN_DEP_MAP.put("{NP\\NP}/{NP\\NP}", new Integer(1025));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[pss]\\NP}}/NP", new Integer(1026));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/{S[b]\\NP}", new Integer(1027));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/PP}/{S[adj]\\NP}}/NP", new Integer(1028));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}\\NP", new Integer(1029));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{{S[to]\\NP}/NP}}/NP", new Integer(1030));
		PENN_DEP_MAP.put("{S[dcl]\\NP[thr]}/{S[adj]\\NP}", new Integer(1031));
		PENN_DEP_MAP.put("{S[b]\\NP[thr]}/{S[to]\\NP}", new Integer(1032));
		PENN_DEP_MAP.put("{{S/S}/{S[b]\\NP}}/NP", new Integer(1033));
		PENN_DEP_MAP.put("NP\\NP", new Integer(1034));
		PENN_DEP_MAP.put("{S/S}/{S[dcl]\\NP}", new Integer(1035));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/conj", new Integer(1036));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/NP", new Integer(1037));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[dcl]\\NP}}/NP", new Integer(1038));
		PENN_DEP_MAP.put("{{{NP\\NP}\\{NP\\NP}}\\{{NP\\NP}\\{NP\\NP}}}/{{NP\\NP}\\{NP\\NP}}", new Integer(1039));
		PENN_DEP_MAP.put("{{PP\\PP}/S[qem]}\\NP", new Integer(1040));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/{S[adj]\\NP}", new Integer(1041));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/{S[to]\\NP}}/PP", new Integer(1042));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}\\NP}/PP", new Integer(1043));
		PENN_DEP_MAP.put("{S[pss]\\NP}/{S[ng]\\NP}", new Integer(1044));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[adj]", new Integer(1045));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/NP", new Integer(1046));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/{S[ng]\\NP}}/NP}/NP", new Integer(1047));
		PENN_DEP_MAP.put("{{{S\\NP}/{S\\NP}}\\{{S\\NP}/{S\\NP}}}/{S[asup]\\NP}", new Integer(1048));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[b]\\NP}}/{S[adj]\\NP}", new Integer(1049));
		PENN_DEP_MAP.put("{S[ng]\\NP}/{S[pss]\\NP}", new Integer(1050));
		PENN_DEP_MAP.put("{{S\\S}/{S\\S}}/{{S\\S}/{S\\S}}", new Integer(1051));
		PENN_DEP_MAP.put("{{S[pt]\\{S[dcl]\\NP}}\\NP}/PP", new Integer(1052));
		PENN_DEP_MAP.put("{{{S[b]\\NP}/S[em]}/{S[adj]\\NP}}/NP[expl]", new Integer(1053));
		PENN_DEP_MAP.put("{S[for]/{S[to]\\NP}}/NP", new Integer(1054));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[pss]\\NP}", new Integer(1055));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}/{S[asup]\\NP}", new Integer(1056));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[em]}/NP", new Integer(1057));
		PENN_DEP_MAP.put("{{{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}}\\{{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}}}/{{{NP\\NP}\\{NP\\NP}}/{{NP\\NP}\\{NP\\NP}}}", new Integer(1058));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[pt]\\NP}}/NP", new Integer(1059));
		PENN_DEP_MAP.put("{S[dcl]\\{S[adj]\\NP}}/{S[b]\\NP}", new Integer(1060));
		PENN_DEP_MAP.put("{S[qem]/{S[dcl]/NP}}/{S[adj]\\NP}", new Integer(1061));
		PENN_DEP_MAP.put("{{S[wq]/S[q]}\\{{NP\\NP}/NP}}/N", new Integer(1062));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/{S[adj]\\NP}}/PP}/{S[adj]\\NP}", new Integer(1063));
		PENN_DEP_MAP.put("{S[to]\\NP}/{S[b]\\NP}", new Integer(1064));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/NP}/{S[adj]\\NP}", new Integer(1065));
		PENN_DEP_MAP.put("{S\\S}\\{S\\S}", new Integer(1066));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/S[for]}/{S[adj]\\NP}}/NP[expl]", new Integer(1067));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/S[dcl]}/{S[adj]\\NP}", new Integer(1068));
		PENN_DEP_MAP.put("{{S[dcl]\\PP}/NP}/{S[b]\\NP}", new Integer(1069));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/PP", new Integer(1070));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}\\{S[adj]\\NP}", new Integer(1071));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/S[dcl]}/PP}/NP", new Integer(1072));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[b]\\NP}}/NP", new Integer(1073));
		PENN_DEP_MAP.put("{{S[q]/{S[to]\\NP}}/{S[adj]\\NP}}/NP[expl]", new Integer(1074));
		PENN_DEP_MAP.put("S[dcl]/NP", new Integer(1075));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/PP}/PP", new Integer(1076));
		PENN_DEP_MAP.put("S[b]\\S[qem]", new Integer(1077));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/NP}/NP", new Integer(1078));
		PENN_DEP_MAP.put("{{S/S}/{S/S}}\\{{S/S}/{S/S}}", new Integer(1079));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(1080));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[ng]\\NP}}/{S[adj]\\NP}", new Integer(1081));
		PENN_DEP_MAP.put("{N/N}\\{N/N}", new Integer(1082));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[to]\\NP}}/PP", new Integer(1083));
		PENN_DEP_MAP.put("S[intj]\\NP", new Integer(1084));
		PENN_DEP_MAP.put("{S[dcl]\\S[b]}/NP", new Integer(1085));
		PENN_DEP_MAP.put("{S[pss]\\NP}/S[to]", new Integer(1086));
		PENN_DEP_MAP.put("NP/{S[b]/NP}", new Integer(1087));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/PP}/{S[adj]\\NP}", new Integer(1088));
		PENN_DEP_MAP.put("{S\\NP}/{S[b]\\NP}", new Integer(1089));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{{S[b]\\NP}/NP}", new Integer(1090));
		PENN_DEP_MAP.put("S/S[dcl]", new Integer(1091));
		PENN_DEP_MAP.put("N/S[dcl]", new Integer(1092));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[adj]\\NP}}/NP", new Integer(1093));
		PENN_DEP_MAP.put("{{N/N}\\{N/N}}/{S[adj]\\NP}", new Integer(1094));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/N", new Integer(1095));
		PENN_DEP_MAP.put("{S[dcl]\\PP}/S[em]", new Integer(1096));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/{S[pt]\\NP}", new Integer(1097));
		PENN_DEP_MAP.put("{{S[adj]\\NP}\\{S[adj]\\NP}}/N[num]", new Integer(1098));
		PENN_DEP_MAP.put("{NP/NP}/{S[asup]\\NP}", new Integer(1099));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[em]}/PP", new Integer(1100));
		PENN_DEP_MAP.put("{NP/{S[to]\\N}}/N", new Integer(1101));
		PENN_DEP_MAP.put("{{S/S}/{S/S}}/N", new Integer(1102));
		PENN_DEP_MAP.put("{{NP\\NP}/S[dcl]}\\{{NP\\NP}/NP}", new Integer(1103));
		PENN_DEP_MAP.put("{S[pss]\\NP}/{S[adj]\\NP}", new Integer(1104));
		PENN_DEP_MAP.put("{S\\NP}/S[dcl]", new Integer(1105));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[b]\\NP}}\\NP}/S[dcl]", new Integer(1106));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[q]/NP}}/N", new Integer(1107));
		PENN_DEP_MAP.put("{{N/N}/{N/N}}\\{S[adj]\\NP}", new Integer(1108));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}}/{S[adj]\\NP}", new Integer(1109));
		PENN_DEP_MAP.put("{S[dcl]\\{S[pt]\\NP}}/NP", new Integer(1110));
		PENN_DEP_MAP.put("{{S[qem]/S[dcl]}/N}/{S[adj]\\NP}", new Integer(1111));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/N[num]", new Integer(1112));
		PENN_DEP_MAP.put("{{S[b]\\NP}\\NP}/S[dcl]", new Integer(1113));
		PENN_DEP_MAP.put("{N/N}\\{S[adj]\\NP}", new Integer(1114));
		PENN_DEP_MAP.put("{S[b]\\NP[thr]}/NP", new Integer(1115));
		PENN_DEP_MAP.put("{N/NP}/{S[to]\\NP}", new Integer(1116));
		PENN_DEP_MAP.put("S[qem]/{S[adj]\\NP}", new Integer(1117));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/NP}/{S[ng]\\NP}", new Integer(1118));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/{S[adj]\\NP}}/N[num]", new Integer(1119));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[asup]\\NP}", new Integer(1120));
		PENN_DEP_MAP.put("{S[b]\\NP}/{S[pt]\\NP}", new Integer(1121));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/S[bem]", new Integer(1122));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/PP}/NP", new Integer(1123));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[for]}/NP", new Integer(1124));
		PENN_DEP_MAP.put("{S\\S}/N[num]", new Integer(1125));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/S[em]", new Integer(1126));
		PENN_DEP_MAP.put("S[qem]/{{S[to]\\NP}/NP}", new Integer(1127));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[qem]}/{S[adj]\\NP}", new Integer(1128));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[ng]\\NP}}/NP", new Integer(1129));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[qem]}/NP", new Integer(1130));
		PENN_DEP_MAP.put("{N/N}/{{S[to]\\NP}/NP}", new Integer(1131));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[em]}/NP", new Integer(1132));
		PENN_DEP_MAP.put("conj", new Integer(1133));
		PENN_DEP_MAP.put("{S/PP}/NP", new Integer(1134));
		PENN_DEP_MAP.put("N/NP", new Integer(1135));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/S[dcl]", new Integer(1136));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[q]", new Integer(1137));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/{S[adj]\\NP}}/PP", new Integer(1138));
		PENN_DEP_MAP.put("{{{NP\\NP}\\{NP\\NP}}/{S[dcl]\\N}}/N", new Integer(1139));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[ng]\\NP}}/{S[adj]\\NP}", new Integer(1140));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/NP", new Integer(1141));
		PENN_DEP_MAP.put("{{S\\S}\\{S\\S}}/S[dcl]", new Integer(1142));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[em]}/S[qem]", new Integer(1143));
		PENN_DEP_MAP.put("{PP\\NP}/NP", new Integer(1144));
		PENN_DEP_MAP.put("S[to]\\NP", new Integer(1145));
		PENN_DEP_MAP.put("{{S\\S}/{S[pt]\\NP}}/NP", new Integer(1146));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[dcl]/NP}", new Integer(1147));
		PENN_DEP_MAP.put("{S[wq]/{S[to]\\NP}}/{S[adj]\\NP}", new Integer(1148));
		PENN_DEP_MAP.put("{S[em]/{S[pss]\\NP}}/NP", new Integer(1149));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{S[dcl]\\NP}", new Integer(1150));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[em]}/NP", new Integer(1151));
		PENN_DEP_MAP.put("{S\\S}/S[q]", new Integer(1152));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{{S\\NP}/{S\\NP}}", new Integer(1153));
		PENN_DEP_MAP.put("PP/S[qem]", new Integer(1154));
		PENN_DEP_MAP.put("{S[ng]\\NP}/{S[pt]\\NP}", new Integer(1155));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}/{{{S[adj]\\NP}/PP}/{{S[adj]\\NP}/PP}}", new Integer(1156));
		PENN_DEP_MAP.put("{{S[b]\\NP}/NP}/NP", new Integer(1157));
		PENN_DEP_MAP.put("{PP\\PP}\\{PP\\PP}", new Integer(1158));
		PENN_DEP_MAP.put("{S[pss]\\NP}/S[em]", new Integer(1159));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[b]\\NP}}/PP", new Integer(1160));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}\\{{{S[adj]\\NP}\\{S[adj]\\NP}}/{{S[adj]\\NP}\\{S[adj]\\NP}}}", new Integer(1161));
		PENN_DEP_MAP.put("S[q]/PP", new Integer(1162));
		PENN_DEP_MAP.put("S[pss]", new Integer(1163));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\NP}/S[dcl]", new Integer(1164));
		PENN_DEP_MAP.put("{NP\\NP}/S[ng]", new Integer(1165));
		PENN_DEP_MAP.put("{N/S[qem]}\\NP", new Integer(1166));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/NP}/PP", new Integer(1167));
		PENN_DEP_MAP.put("{{{S[adj]\\NP}\\{S[adj]\\NP}}\\{{S[adj]\\NP}\\{S[adj]\\NP}}}/{S[dcl]\\NP}", new Integer(1168));
		PENN_DEP_MAP.put("{S[dcl]\\NP}/{S[em]\\NP}", new Integer(1169));
		PENN_DEP_MAP.put("{S[dcl]\\{S[to]\\NP}}/{S[adj]\\NP}", new Integer(1170));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/NP}/{S[adj]\\NP}", new Integer(1171));
		PENN_DEP_MAP.put("S[frg]/{S[adj]\\NP}", new Integer(1172));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S}/NP", new Integer(1173));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[to]\\NP}}/PP", new Integer(1174));
		PENN_DEP_MAP.put("{{S/S}\\NP}\\NP", new Integer(1175));
		PENN_DEP_MAP.put("{S[dcl]\\NP[expl]}/{S[adj]\\NP}", new Integer(1176));
		PENN_DEP_MAP.put("{S[frg]/NP}/NP", new Integer(1177));
		PENN_DEP_MAP.put("{S[qem]/{S[dcl]/N}}/N", new Integer(1178));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S}/PP", new Integer(1179));
		PENN_DEP_MAP.put("N/PP", new Integer(1180));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[for]}/{S[adj]\\NP}", new Integer(1181));
		PENN_DEP_MAP.put("{{S[dcl]\\S[dcl]}\\NP}/{S[ng]\\NP}", new Integer(1182));
		PENN_DEP_MAP.put("{S[b]\\NP}/{S[b]\\NP}", new Integer(1183));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}/NP", new Integer(1184));
		PENN_DEP_MAP.put("{{PP/PP}\\{PP/PP}}/NP", new Integer(1185));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/NP}/{S[adj]\\NP}", new Integer(1186));
		PENN_DEP_MAP.put("{S[dcl]\\{S[ng]\\NP}}/{S[b]\\NP}", new Integer(1187));
		PENN_DEP_MAP.put("{N\\N}/N[num]", new Integer(1188));
		PENN_DEP_MAP.put("{{NP\\NP}\\{NP\\NP}}/{NP\\NP}", new Integer(1189));
		PENN_DEP_MAP.put("{PP\\NP}/PP", new Integer(1190));
		PENN_DEP_MAP.put("S[wq]/S[poss]", new Integer(1191));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/PP}/{S[adj]\\NP}", new Integer(1192));
		PENN_DEP_MAP.put("PP/S[dcl]", new Integer(1193));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}/{S[ng]\\NP}}/NP", new Integer(1194));
		PENN_DEP_MAP.put("{S[q]/S[qem]}/NP", new Integer(1195));
		PENN_DEP_MAP.put("{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{S[pss]\\NP}", new Integer(1196));
		PENN_DEP_MAP.put("{S[adj]\\NP}\\NP", new Integer(1197));
		PENN_DEP_MAP.put("{S[pss]\\NP}/S", new Integer(1198));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[for]}/{S[adj]\\NP}", new Integer(1199));
		PENN_DEP_MAP.put("{NP\\NP}/{S[adj]\\NP}", new Integer(1200));
		PENN_DEP_MAP.put("{{S\\NP}/{S\\NP}}/{S[ng]\\NP}", new Integer(1201));
		PENN_DEP_MAP.put("{S[dcl]/{S[ng]\\NP}}/NP", new Integer(1202));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[to]\\NP}}/NP", new Integer(1203));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/{S[b]\\NP}}/PP", new Integer(1204));
		PENN_DEP_MAP.put("S[q]/NP", new Integer(1205));
		PENN_DEP_MAP.put("{{S[b]\\NP}/{S[b]\\NP}}/NP", new Integer(1206));
		PENN_DEP_MAP.put("S[poss]/S[dcl]", new Integer(1207));
		PENN_DEP_MAP.put("{N/N}/{N/N}", new Integer(1208));
		PENN_DEP_MAP.put("{{S[for]\\NP[expl]}/{S[to]\\NP}}/NP", new Integer(1209));
		PENN_DEP_MAP.put("S[bem]/S[b]", new Integer(1210));
		PENN_DEP_MAP.put("S[poss]/{S[pss]\\NP}", new Integer(1211));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/{S[asup]\\NP}", new Integer(1212));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[poss]}/NP", new Integer(1213));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[b]\\NP}}\\NP}/{S[to]\\NP}", new Integer(1214));
		PENN_DEP_MAP.put("LRB", new Integer(1215));
		PENN_DEP_MAP.put("{S[dcl]\\NP}\\NP", new Integer(1216));
		PENN_DEP_MAP.put("{S[pss]\\NP}/PP", new Integer(1217));
		PENN_DEP_MAP.put("{{S[adj]\\NP}/PP}/{S[adj]\\NP}", new Integer(1218));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[qem]}/NP", new Integer(1219));
		PENN_DEP_MAP.put("{{S/S}\\{S/S}}\\NP", new Integer(1220));
		PENN_DEP_MAP.put("{S[dcl]/NP}/NP", new Integer(1221));
		PENN_DEP_MAP.put("{{{{NP\\NP}\\{NP\\NP}}/S[dcl]}\\{{NP\\NP}/NP}}/N", new Integer(1222));
		PENN_DEP_MAP.put("{S/S}/S[poss]", new Integer(1223));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[em]}/{S[adj]\\NP}", new Integer(1224));
		PENN_DEP_MAP.put("{S/S}/S[dcl]", new Integer(1225));
		PENN_DEP_MAP.put("{S[dcl]\\S[b]}\\NP", new Integer(1226));
		PENN_DEP_MAP.put("{S[pss]\\NP}/{S[b]\\NP}", new Integer(1227));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}", new Integer(1228));
		PENN_DEP_MAP.put("{{S/S}/S[dcl]}/N", new Integer(1229));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[ng]\\NP}}/NP", new Integer(1230));
		PENN_DEP_MAP.put("{{S[dcl]/S[dcl]}\\NP}/NP", new Integer(1231));
		PENN_DEP_MAP.put("{S[wq]/{S[q]/N}}/N", new Integer(1232));
		PENN_DEP_MAP.put("N/{S[to]\\NP}", new Integer(1233));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[dcl]\\NP}}\\{{NP\\NP}/NP}", new Integer(1234));
		PENN_DEP_MAP.put("{NP\\NP}/{S[b]\\NP}", new Integer(1235));
		PENN_DEP_MAP.put("{{S[b]\\NP}/S[bem]}/PP", new Integer(1236));
		PENN_DEP_MAP.put("{{NP\\NP}/{S[dcl]/PP}}\\{{NP\\NP}/NP}", new Integer(1237));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}/{{S\\NP}\\{S\\NP}}}}/{S[asup]\\NP}", new Integer(1238));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{S[adj]\\NP}}\\NP}/{S[ng]\\NP}", new Integer(1239));
		PENN_DEP_MAP.put("{{{S[dcl]\\NP}/{S[to]\\NP}}/NP}/NP", new Integer(1240));
		PENN_DEP_MAP.put("{NP\\NP}\\{{NP\\NP}/NP}", new Integer(1241));
		PENN_DEP_MAP.put("{{S\\NP}\\{S\\NP}}/S[ng]", new Integer(1242));
		PENN_DEP_MAP.put("S[dcl]\\NP", new Integer(1243));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/{S[to]\\NP}}/NP", new Integer(1244));
		PENN_DEP_MAP.put("{S[adj]\\NP}/S[qem]", new Integer(1245));
		PENN_DEP_MAP.put("{PP\\PP}/{S[dcl]\\NP}", new Integer(1246));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[dcl]\\NP}}/NP}/S[dcl]", new Integer(1247));
		PENN_DEP_MAP.put("{{S[pt]\\NP}/{S[pss]\\NP}}/NP", new Integer(1248));
		PENN_DEP_MAP.put("{S[pss]\\NP}/NP", new Integer(1249));
		PENN_DEP_MAP.put("{S[frg]/NP}/PP", new Integer(1250));
		PENN_DEP_MAP.put("S[frg]/S[em]", new Integer(1251));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}/{{{S\\NP}\\{S\\NP}}\\{{S\\NP}\\{S\\NP}}}}/NP", new Integer(1252));
		PENN_DEP_MAP.put("{S[dcl]\\NP[thr]}/{S[pss]\\NP}", new Integer(1253));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[em]}/{S[to]\\NP}", new Integer(1254));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}\\NP}/{S[ng]\\NP}", new Integer(1255));
		PENN_DEP_MAP.put("{S[pt]\\NP}/{S[to]\\NP}", new Integer(1256));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[qem]}/PP", new Integer(1257));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/{S[to]\\NP}}/{S[adj]\\NP}", new Integer(1258));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}\\NP}/S[em]", new Integer(1259));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S[em]}/PP", new Integer(1260));
		PENN_DEP_MAP.put("{{S[pss]\\NP}/{S[adj]\\NP}}/NP", new Integer(1261));
		PENN_DEP_MAP.put("{{S[dcl]\\{S[adj]\\NP}}\\NP}/S[dcl]", new Integer(1262));
		PENN_DEP_MAP.put("S[qem]", new Integer(1263));
		PENN_DEP_MAP.put("{{S[to]\\NP}/{S[b]\\NP}}/{S[b]\\NP}", new Integer(1264));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[qem]}/NP", new Integer(1265));
		PENN_DEP_MAP.put("{N\\N}/N", new Integer(1266));
		PENN_DEP_MAP.put("PP/N", new Integer(1267));
		PENN_DEP_MAP.put("{{NP\\NP}/{NP\\NP}}/S[dcl]", new Integer(1268));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S[em]}/PP", new Integer(1269));
		PENN_DEP_MAP.put("{S[q]/{S[b]\\NP}}/NP[expl]", new Integer(1270));
		PENN_DEP_MAP.put("S[frg]", new Integer(1271));
		PENN_DEP_MAP.put("{{{{NP\\NP}/NP}/NP}/NP}/NP", new Integer(1272));
		PENN_DEP_MAP.put("{S[dcl]\\{S[adj]\\NP}}/S[dcl]", new Integer(1273));
		PENN_DEP_MAP.put("{N/PP}/{S[adj]\\NP}", new Integer(1274));
		PENN_DEP_MAP.put("{S[ng]\\NP}/NP", new Integer(1275));
		PENN_DEP_MAP.put("{{S[b]\\NP}/NP}/PP", new Integer(1276));
		PENN_DEP_MAP.put("{S[pt]\\NP}/{S[adj]\\NP}", new Integer(1277));
		PENN_DEP_MAP.put("S[frg]/{S[to]\\NP}", new Integer(1278));
		PENN_DEP_MAP.put("{NP/NP}/{NP/NP}", new Integer(1279));
		PENN_DEP_MAP.put("N/S[bem]", new Integer(1280));
		PENN_DEP_MAP.put("{{N\\N}/S[dcl]}\\{{NP\\NP}/NP}", new Integer(1281));
		PENN_DEP_MAP.put("{{NP\\NP}\\NP}/{S[b]\\NP}", new Integer(1282));
		PENN_DEP_MAP.put("{{S[dcl]\\NP[expl]}/S[dcl]}/PP", new Integer(1283));
		PENN_DEP_MAP.put("{{{{S\\NP}\\{S\\NP}}/N}\\{{{S\\NP}\\{S\\NP}}/N}}/{{{S\\NP}\\{S\\NP}}/N}", new Integer(1284));
		PENN_DEP_MAP.put("{{S[ng]\\NP}/S}/NP", new Integer(1285));
		PENN_DEP_MAP.put("{{S[dcl]\\NP}/S}/{S[adj]\\NP}", new Integer(1286));
	}

	public static final int PENN_DEP_NONE = 0;
	public static final int PENN_DEP_COUNT = 1287;
	
	public static final int PENN_DEP_COUNT_BITS = 11;

	public static final int NONE = 0;
	public static final int ROOT = 1;
	public static final int FIRST = 1;
	public static final int COUNT = PENN_DEP_COUNT;
	public static final int MAX_COUNT = COUNT;
	public static final int SIZE = PENN_DEP_COUNT_BITS;

	protected int m_code;
	
	public EDependencyLabel(final String str) {
		load(str);
	}
	
	public void load(int u) {
		m_code = u;
	}
	
	public void load(final String str) {
		Integer i = PENN_DEP_MAP.get(str);
		m_code = i == null ? PENN_DEP_NONE : i.intValue();
	}
	
	@Override
	public int hashCode() {
		return m_code;
	}
	
	@Override
	public boolean equals(final Object o) {
		return m_code == ((EDependencyLabel)o).m_code;
	}
	
	@Override
	public String toString() {
		return PENN_DEP_STRINGS[m_code];
	}
	
	public static String str(final int code) {
		return PENN_DEP_STRINGS[code];
	}
	
	public static int code(final String label) {
		Integer i = PENN_DEP_MAP.get(label);
		return i == null ? PENN_DEP_NONE : i.intValue();
	}
	
	
}
