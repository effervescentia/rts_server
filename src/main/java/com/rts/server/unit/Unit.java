package com.rts.server.unit;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.rts.server.attribute.Attribute;
import com.rts.server.attribute.AttributeType;

public abstract class Unit {
	private static final AtomicInteger uidCounter = new AtomicInteger();
	protected Map<AttributeType, Attribute> attributes = new ConcurrentHashMap<>();

	// private static final Logger log = Logger.getLogger(Unit.class);

	public final int uid;
	private Point position;

	public Unit() {
		uid = uidCounter.getAndIncrement();
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point pPosition) {
		position.setLocation(pPosition);
	}

	public Attribute getAttribute(AttributeType pType) {
		return attributes.get(pType);
	}

	public List<Attribute> getAttributes() {
		return (List<Attribute>) attributes.values();
	}

	public void addAttribute(Attribute pAttribute) {
		attributes.put(pAttribute.getType(), pAttribute);
	}

	public void addAttributes(List<Attribute> pAttributes) {
		for (Attribute attribute : pAttributes) {
			attributes.put(attribute.getType(), attribute);
		}
	}

	public boolean hasAttribute(AttributeType pType) {
		return attributes.containsKey(pType);
	}

	public boolean hasAttributes(List<AttributeType> pAttributeTypes) {
		return attributes.keySet().containsAll(pAttributeTypes);
	}

	public void removeAttribute(AttributeType pType) {
		attributes.remove(pType);
	}

}