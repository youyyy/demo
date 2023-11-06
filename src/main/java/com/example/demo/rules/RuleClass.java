package com.example.demo.rules;/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.api.RulesEngineParameters;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author youyi
 * @program demo
 * @description 规则引擎
 * @date 2022-10-18 16:13
 **/
public class RuleClass {

    @Rule(priority = 1) //规则设定优先级
    public static class FizzRule {
        @Condition
        public boolean isFizz(Facts facts) {
            Integer number = facts.get("number");
            return number % 5 == 0;
        }

        @Action
        public void printFizz() {
            System.out.print("fizz\n");
        }
    }

    @Rule(priority = 2)
    public static class BuzzRule {
        @Condition
        public boolean isBuzz(@Fact("number") Integer number) {
            return number % 7 == 0;
        }

        @Action
        public void printBuzz() {
            System.out.print("buzz\n");
        }
    }


//    public static class FizzBuzzRule extends UnitRuleGroup {
//
//        public FizzBuzzRule(Object... rules) {
//            for (Object rule : rules) {
//                addRule(rule);
//            }
//        }
//
//        @Override
//        public int getPriority() {
//            return 0;
//        }
//    }

    @Rule(priority = 3)
    public static class NonFizzBuzzRule {

        @Condition
        public boolean isNotFizzNorBuzz(@Fact("number") Integer number) {
            // can return true, because this is the latest rule to trigger according to
            // assigned priorities
            // and in which case, the number is not fizz nor buzz
            return number % 5 != 0 || number % 7 != 0;
        }

        @Action
        public void printInput(@Fact("number") Integer number) {
            System.out.print(number+"\n");
        }
    }
    public static void main(String[] args) {
        // 创建规则引擎
        RulesEngineParameters parameters = new RulesEngineParameters().skipOnFirstAppliedRule(true);
        RulesEngine fizzBuzzEngine = new DefaultRulesEngine(parameters);

        // 创建规则集并注册规则
        Rules rules = new Rules();
        rules.register(new RuleClass.FizzRule());
        rules.register(new RuleClass.BuzzRule());
        rules.register(new RuleClass.NonFizzBuzzRule());

        // 执行规则
        Facts facts = new Facts();
        for (int i = 1; i <= 100; i++) {
            facts.put("number", i);
            fizzBuzzEngine.fire(rules, facts);
        }
    }
}
