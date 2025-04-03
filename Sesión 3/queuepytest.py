import array
import pytest

class Queue:
    def __init__(self, size_max):
        assert size_max > 0
        self.max = size_max
        self.head = 0
        self.tail = 0
        self.size = 0
        self.data = array.array('i', range(size_max))

    def empty(self):
        return self.size == 0

    def full(self):
        return self.size == self.max

    def enqueue(self, x):
        if self.size == self.max:
            return False
        self.data[self.tail] = x
        self.size += 1
        self.tail += 1
        if self.tail == self.max:
            self.tail = 0
        return True

    def dequeue(self):
        if self.size == 0:
            return None
        x = self.data[self.head]
        self.size -= 1
        self.head += 1
        if self.head == self.max:
            self.head = 0
        return x


# Test 1: Casos Básicos
def test_basic_operations():
    q = Queue(2)
    
    # Verificar cola vacía
    assert q.empty()
    assert not q.full()
    assert q.dequeue() is None
    
    # Encolar un elemento
    assert q.enqueue(10)
    assert not q.empty()
    assert not q.full()
    
    # Encolar segundo elemento
    assert q.enqueue(11)
    assert not q.empty()
    assert q.full()
    
    # Intentar encolar en cola llena
    assert not q.enqueue(12)
    
    # Desencolar elementos
    assert q.dequeue() == 10
    assert q.dequeue() == 11
    assert q.dequeue() is None
    assert q.empty()
    assert not q.full()


# Test 2: Cola llena y vacía
def test_full_and_empty():
    q = Queue(3)
    
    # Verificar estado inicial
    assert q.empty()
    assert not q.full()
    
    # Llenar la cola
    assert q.enqueue(100)
    assert q.enqueue(200)
    assert q.enqueue(300)
    
    # Verificar estado lleno
    assert q.full()
    assert not q.empty()
    assert not q.enqueue(400)  # No debería poder encolar
    
    # Vaciar la cola
    assert q.dequeue() == 100
    assert q.dequeue() == 200
    assert q.dequeue() == 300
    
    # Verificar estado vacío
    assert q.empty()
    assert not q.full()
    assert q.dequeue() is None


# Test 3: Comportamiento circular
def test_circular_behavior():
    q = Queue(3)
    
    # Llenar la cola
    assert q.enqueue(1)
    assert q.enqueue(2)
    assert q.enqueue(3)
    
    # Desencolar dos elementos
    assert q.dequeue() == 1
    assert q.dequeue() == 2
    # Head ahora en 2, tail en 0 (circular)
    
    # Encolar nuevos elementos (comportamiento circular)
    assert q.enqueue(4)  # Posición 0
    assert q.enqueue(5)  # Posición 1
    # Tail ahora en 2
    
    # Verificar estado lleno
    assert q.full()
    
    # Desencolar verificando orden correcto
    assert q.dequeue() == 3  # Head en 2
    assert q.dequeue() == 4  # Head pasa a 0
    assert q.dequeue() == 5  # Head pasa a 1
    assert q.dequeue() is None  # Cola vacía
    
    # Volver a llenar después de comportamiento circular
    assert q.enqueue(6)
    assert q.enqueue(7)
    assert q.enqueue(8)
    assert not q.enqueue(9)  # Cola llena

