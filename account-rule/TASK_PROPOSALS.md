# Codebase Issue Triage: Proposed Tasks

## 1) Typo fix task
**Task:** Rename misspelled identifiers `TreatementTools` and `Parametres` to `TreatmentTools` and `Parameters`, and update all usages (including JSON action strings and field names) to keep naming consistent.

**Why:** These names are misspelled across enum/model types and related references, which makes the API harder to understand and increases maintenance friction.

**Primary files to touch:**
- `src/main/java/com/ruleEngine/accountrule/enums/TreatementTools.java`
- `src/main/java/com/ruleEngine/accountrule/model/Parametres.java`
- `src/main/java/com/ruleEngine/accountrule/service/RuleService.java`
- `src/main/resources/account-rules.json`

---

## 2) Bug fix task
**Task:** Fix `RuleService#getAllRuleByNamespace` so it does not mutate `ruleList` while iterating and so it actually returns filtered results for the requested namespace.

**Why:** The current implementation adds elements back into the same list inside a for-each loop and returns during the first iteration, which can cause incorrect behavior and potential `ConcurrentModificationException`.

**Primary file to touch:**
- `src/main/java/com/ruleEngine/accountrule/service/RuleService.java`

---

## 3) Comment/documentation discrepancy task
**Task:** Update `RuleReader` comments and loading approach so documentation/comments match runtime behavior; load `account-rules.json` via classpath (e.g., `ClassPathResource`) and remove stale commented-out code snippets that suggest a different path strategy.

**Why:** The active code uses `TypeReference.class.getResourceAsStream("src/main/resources/account-rules.json")`, while comments imply file-based loading from `src/main/resources`. This discrepancy is confusing and error-prone, especially after packaging.

**Primary file to touch:**
- `src/main/java/com/ruleEngine/accountrule/service/RuleReader.java`

---

## 4) Test improvement task
**Task:** Replace/augment the single `contextLoads` smoke test with focused unit tests for rule filtering and rule loading (e.g., `getAllRuleByNamespace`, rule parsing, and a controller endpoint test).

**Why:** The current test suite has only one empty context startup test and does not verify core domain behavior, so regressions in rule evaluation or namespace filtering can pass undetected.

**Primary test files to add/update:**
- `src/test/java/com/ruleEngine/accountrule/AccountRuleApplicationTests.java`
- Add dedicated tests under `src/test/java/com/ruleEngine/accountrule/service/` and `.../controller/`
