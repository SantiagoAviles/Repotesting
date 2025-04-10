class Node:
	def __init__(self,key):
		self.key = key
		self.left = self.right = None

	def equals(self, node):
		return self.key == node.key

class SplayTree:
	def __init__(self):
		self.root = None
		self.header = Node(None)

	def insert(self, key):
		if (self.root == None):
			self.root = Node(key)
			return
		self.splay(key)
		if self.root.key == key:
			#si la key ya está en el arbol, no hacer nada
			return

		n = Node(key)
		if key < self.root.key:
			n.left = self.root.left
			n.right = self.root
			self.root.left = None
		else:
			n.right = self.root.right
			n.left = self.root
			self.root.right = None
		self.root = n

	def remove(self,key):
		self.splay(key)
		if key != self.root.key:
			raise 'key no hallada en el arbol'

		#borrando la raiz
		if self.root.left == None:
			self.root = self.root.right
		else:
			x =	self.root.right
			self.root = self.root.left
			self.splay(key)
			self.root.right = x
			
	def findMin(self):
 		if self.root == None:
 			return None
 		x = self.root
 		while x.left != None:
 			x = x.left
 		self.splay(x.key)
 		return x.key

	def findMax(self):
 		if self.root == None:
 			return None
 		x = self.root
 		while x.right != None:
 			x = x.right
 		self.splay(x.key)
 		return x.key

	def find(self,key):
 		if self.root == None:
 			return None
 		self.splay(key)
 		if self.root.key != key:
 			return None
 		return self.root.key

	def isEmpty(self):
 		return self.root == None

	def splay(self,key):
 		l = r = self.header
 		t = self.root
 		self.header.left = self.header.right = None
 		while True:
 			if key < t.key:
 				if t.left == None:
 					break
 				if key < t.left.key:
 					y = t.left
 					t.left = y.right
 					y.right = t
 					t = y
 					if t.left == None:
 						break
 				r.left = t
 				r = t
 				t = t.left
 			elif key > t.key:
 				if t.right == None:
 					break
 				if key > t.right.key:
 					y = t.right
 					t.right = y.left
 					y.left = t
 					t = y
 					if t.right == None:
 						break
 				l.right = t
 				l = t
 				t = t.right
 			else:
 				break
 		l.right = t.left
 		r.left = t.right
 		t.left = self.header.right
 		r.right = self.header.left
 		self.root = t

import unittest
class TestCase(unittest.TestCase):
	def setUp(self):
		self.keys = [0,1,2,3,4,5,6,7,8,9]
		self.t = SplayTree()
		for key in self.keys:
			self.t.insert(key)

	def testInsert(self):
		for key in self.keys:
			self.assertEquals(key,self.t.find(key))
	
	def testRemove(self):
		for key in self.keys:
			self.t.remove(key)
			self.assertEquals(self.t.find(key), None)

	def testLargeInserts(self):
		t = SplayTree()
		nums = 40000
		gap = 307
		i = gap
		while i != 0:
			t.insert(i)
			i = (i+gap)%nums

	def testIsEmpty(self):
		self.assertFalse(self.t.isEmpty())
		t = SplayTree()
		self.assertTrue(t.isEmpty())

	def testMinMax(self):
		self.assertEquals(self.t.findMin(),0)	
		self.assertEquals(self.t.findMax(),9)