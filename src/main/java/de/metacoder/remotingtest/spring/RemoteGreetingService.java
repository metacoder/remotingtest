package de.metacoder.remotingtest.spring;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteGreetingService extends Remote {

	String hello(String name) throws RemoteException;
}
