grammar SimpleSearchPredicate;

options {
  language = Java;
}

@header {
package suman.simplesearchpredicate;
}

//Ex: 1. email search - attributes from, to, subject, body: boolean values (has:), date ranges
//       from:abc@def.com to:foo@abc.com
//    2. task/document search - 
//attr1:val1
//val1
//attr1:val1 keyword_val
//attr1:val1 attr2:val2
//attr1:val1 attr2:val2 keyword_val2
//keyword_val1 keyword_val2

query : (value | pair)+  NEW_LINE
   //breaking the above into two alternatives ( instead of one sub rule with internal alternatives) is not working.
      ;

pair  : attrib ':' value
      ;
      
value : TEXT
      ;

attrib: TEXT
      ;

TEXT : ~[ \n\r:"]+ ;

WS : [ \t]+ -> skip ;
NEW_LINE : [\r?\nEOF]+ ;

