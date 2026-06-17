package com.tom.demo.controller;

import com.tom.demo.model.TrackerModel;
import com.tom.demo.repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller2 {
    private Repository repository;
    Controller2(Repository repository)
    {
        this.repository=repository;
    }
    @PostMapping("/addExpense")
    public TrackerModel addExpense(TrackerModel model){
        return repository.save(model);
    }
    @GetMapping("/viewExpenses")
    public List<TrackerModel> viewExpenses(){
        return repository.findAll();
    }
    @GetMapping("/getExpense/{id}")
    public TrackerModel getExpense(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
    }
    @DeleteMapping("/deleteExpense/{id}")
    public void deleteExpense(@PathVariable Long id){
        repository.deleteById(id);
    }
    @PutMapping("/updateExpense/{id}")
    public TrackerModel updateExpense(@PathVariable Long id,@RequestBody TrackerModel updatedModel){
        TrackerModel expense=repository.findById(id).orElseThrow();
        expense.setDescription(updatedModel.getDescription());
        expense.setAmount(updatedModel.getAmount());
        expense.setCategory(updatedModel.getCategory());
        expense.setDate(updatedModel.getDate());
        return repository.save(expense);
    }

}