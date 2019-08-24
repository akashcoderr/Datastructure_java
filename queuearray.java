class Queue:
  def __init__(self, size):
    self.head = 1
    self.tail = 1
    self.Q = [0]*(size)
    self.size = size

  def is_empty(self):
    if self.tail == self.head:
      return True
    return False

  def is_full(self):
    if self.head == self.tail+1:
      return True
    return False

  def enqueue(self, x):
    if self.is_full():
      print("Queue Overflow")
    else:
      self.Q[self.tail] = x
      if self.tail == self.size:
        self.tail = 1
      else:
        self.tail = self.tail+1

  def dequeue(self):
    if self.is_empty():
      print("Underflow")
    else:
      x = self.Q[self.head]
      if self.head == self.size:
        self.head = 1
      else:
        self.head = self.head+1
      return x

  def display(self):
    i = self.head
    while(i < self.tail):
      print(self.Q[i])
      if(i == self.size):
        i = 0
      i = i+1

if __name__ == '__main__':
  q = Queue(10)
  q.enqueue(10)
  q.enqueue(20)
  q.enqueue(30)
  q.enqueue(40)
  q.enqueue(50)
  q.display()

  print("")

  q.dequeue()
  q.dequeue()
  q.display()

  print("")

  q.enqueue(60)
  q.enqueue(70)
  q.display()
