package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.LinkedList;
import java.util.List;

public class FakeModel implements Model{
    private ModelData modelData = new ModelData();
    
    @Override
    public ModelData getModelData() {
        return modelData;
    }
    
    @Override
    public void loadUsers() {
        List<User> userList = new LinkedList<>();
        int i = 0;
        userList.add(new User("A", ++i, 10));
        userList.add(new User("B", ++i, 11));
        modelData.setUsers(userList);
    }
    
    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
